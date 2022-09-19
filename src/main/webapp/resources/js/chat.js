/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const firebaseConfig = {
    apiKey: "AIzaSyArtgWf5AsJ8109NW-UjrdCKYuY7jvj7Vs",
    authDomain: "btl-chat-3283f.firebaseapp.com",
    databaseURL: "https://btl-chat-3283f-default-rtdb.firebaseio.com",
    projectId: "btl-chat-3283f",
    storageBucket: "btl-chat-3283f.appspot.com",
    messagingSenderId: "182408448828",
    appId: "1:182408448828:web:630003d1dda0beee14ac39",
    measurementId: "G-3TRGG1QCGE"
};
window.firebase.initializeApp(firebaseConfig);
window.firebase.analytics();


function aaa(roomName, userName, otherName, otherPersonName) {

    var mess = Array.from(document.getElementsByClassName("msg"));
    mess.forEach(box => {
        box.remove();
    });


    let chatwith = document.getElementById("chatWith");
    chatwith.innerHTML = "";
    txt = document.createTextNode("chat with " + otherPersonName);
    chatwith.appendChild(txt);

    const dbase = firebase.database().ref('chats/');
    dbase.off("child_added");

    const db = firebase.database().ref('chats/' + roomName);

    db.on("child_added", (snapshot) => {
        const data = snapshot.val();
        console.log(data)
        let msg = document.getElementById("board-msg");
        let h = '';
        if (data.from == userName)
            h += `<div class="d-flex justify-content-end mb-4 msg">
                <div class="msg_cotainer_send">
                  ${data.content}
                </div>
              </div>
      `;
        else
            h += `
              <div class="d-flex justify-content-start mb-4 msg">
                <div class="msg_cotainer">
                  ${data.content}
                </div>
              </div>`;
        msg.insertAdjacentHTML('beforeend', h);
        msg.scroll(0, 1000);
    });

//    let sendMsgButton = document.getElementById("sendButton");
    $("#sendButton").click(() => {
        sendMsg(`${userName}`, `${otherName}`, `${roomName}`);
    });
//    sendMsgButton.addEventListener('click', () => {
//        sendMsg(`${userName}`, `${otherName}`, `${roomName}`);
//    });

}




function sendMsg(yourName, otherName, roomName) {
    var msg = document.getElementById("contentBox").value;

    firebase.database().ref('chats/' + roomName).push().set({
        "content": msg,
        "from": yourName,
        "to": otherName
    });

    document.getElementById("contentBox").value = "";
    document.getElementById("contentBox").focus();

}


function initPage(userName, userId) {

    const listChats = firebase.database().ref('room/' + userId);

    listChats.on("child_added", (snapshot) => {
        const data = snapshot.val();
        console.log(data)
        let msg = document.getElementById("contacts");
        let h = '';
        h = `<li>
              <div class="d-flex bd-highlight" style="cursor: pointer">
                <div class="img_cont">
                  <img src="${data.avatar}" class="rounded-circle user_img">
                  <span class="online_icon offline"></span>

                </div>
                <div class="user_info" onclick="aaa('${data.roomName}', '${userId}', '${data.name}', '${data.otherPersonName}');">
                  <span>${data.otherPersonName}</span>
                  <p>${data.otherPersonName} offline</p>
                </div>
              </div>
            </li>
      `;
        msg.insertAdjacentHTML('beforeend', h);
        msg.scroll(1000, 0);
    });

}


function searchUser(endpoint, myId, myFirstName, myLastName, myAvatar) {
    let name = document.getElementById("search-user").value;
    let contacts = document.getElementById("contacts");
    contacts.style.display = "none";


    let reset = document.getElementById("result-search");
    let child = reset.lastElementChild;
    while (child) {
        reset.removeChild(child);
        child = reset.lastElementChild;
    }

    fetch(endpoint,
            {
                method: 'post',
                body: JSON.stringify({
                    "name": name
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            }
    ).then(function (res) {
        return res.json();
    }).then(function (data) {

        let msg = document.getElementById("result-search");
        let h = '';
        if (data.length === 0) {
            h+= `<li>Khong co ket qua nao trung khop</li>`;
        }

        for (let d of data)
            h += `
                <li>
              <div class="d-flex bd-highlight" style="cursor: pointer">
                <div class="img_cont">
                  <img src="${d.avatar}" class="rounded-circle user_img">
                  <span class="online_icon offline"></span>

                </div>
                <div class="user_info" onclick="createRoom('${d.firstName}', '${d.lastName}', '${d.id}', '${myId}', '${d.avatar}', '${myFirstName}', '${myLastName}', '${myAvatar}');">
                  <span>${d.firstName} ${d.lastName}</span>
                  <p>${d.firstName} ${d.lastName} offline</p>
                </div>
              </div>
            </li>
            `;
        msg.insertAdjacentHTML('beforeend', h);
        msg.scroll(1000, 0);
    });

}

function createRoom(firstName, lastName, id1, id2, avatar, myFirstName, myLastName, myAvatar) {

    let roomName = "";
    if (id1 < id2)
        roomName = id1 + "-" + id2;
    else
        roomName = id2 + "-" + id1;

    console.log(roomName);

    let otherPersonName = firstName + " " + lastName;
    let myName = myFirstName + " " + myLastName;

    const listChats = firebase.database().ref('room/' + id2).orderByChild("name").equalTo(id1).on("value", function (snapshot) {
        if (snapshot.exists() === true) {
            console.log("aaaaa");
            let contacts = document.getElementById("contacts");
            contacts.style.display = "block";


            let s = document.getElementById("result-search");
            s.style.display = "none";
            return aaa(roomName, id2, id1, otherPersonName);
        } else {
            firebase.database().ref('room/' + id2).push().set({
                "avatar": avatar,
                "name": id1,
                "roomName": roomName,
                "otherPersonName": otherPersonName
            });
            firebase.database().ref('room/' + id1).push().set({
                "avatar": myAvatar,
                "name": id2,
                "roomName": roomName,
                "otherPersonName": myName
            });
        }
    });



}




