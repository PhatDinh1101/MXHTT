/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global fetch */

function addPost() {
    let fileInput = document.querySelector('#image');
    let content = document.querySelector('#content').value;
    let topic = document.querySelector('#topic').value;

    let formData = new FormData();

    formData.append('file', fileInput.files[0]);
//    formData.append('content', content);
    formData.append("content", new Blob([JSON.stringify(content)], {
        type: "application/json"
    }));
//    formData.append('topic', topic);
    formData.append("topic", new Blob([JSON.stringify(topic)], {
        type: "application/json"
    }));

    let options = {
        method: 'POST',
        body: formData
    };
    fetch('http://localhost:8080/BTL/api/postPost',
            options).then(function (res) {
        if (res.status === 201)
            window.location.href = "http://localhost:8080/BTL";
    }).catch(err => {
        console.error(err);
    });
}


function loadComment(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let c = document.getElementById("comments");
        let h = '';
        for (let d of data)
            h += `
                <li href="#" class="list-group-item list-group-item-action">${d.comment} - binh luan boi ${d.user.firstName} - ${moment(d.createdDate).locale("vi").fromNow()}</li>
            `
        c.innerHTML = h;
    });
}


async function loadAuctions(endpointAuction, callback) {
    fetch(endpointAuction).then(function (res) {
        return res.json();
    })
            .then(function (data) {
                console.log(data);
                let c = document.getElementById("sortable");
                let h = '';
                for (let d of data)
                    h += `
                <div class="list-item" data-id="3" data-item-sortable-id="0" draggable="true" role="option" aria-grabbed="false">
                    <div><a href="/BTL/profile/${d.user.id}" data-abc="true"><span class="w-40 avatar gd-primary"><img src="${d.user.avatar}" alt="." style="
                                 width: 37px;
                                 height: 37px;
                                 border-radius: 50%;
                                 "></span></a></div>
                        <div class="flex">
                            <a href="/BTL/profile/${d.user.id}" class="item-author text-color" data-abc="true">${d.user.firstName} ${d.user.lastName}</a>
                            <div id ="info-user-${d.user.id}" class="item-except text-muted text-sm h-1x" title="email: ${d.user.email} and Phone: ${d.user.phone} " data-email="${d.user.email}">
                                <strong>email</strong>: ${d.user.email} <strong>|</strong> <strong>phone</strong>: ${d.user.phone}
                            </div>
                        </div>
                        <div class="no-wrap">
                        <div class="item-date text-muted text-sm d-none d-md-block"><strong>Mức giá đưa ra:</strong> ${d.price}</div>
                    </div>
                    <div>
                        <div class="item-action dropdown">
                            <a href="#" data-toggle="dropdown" class="text-muted" data-abc="true">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">
                                <circle cx="12" cy="12" r="1"></circle>
                                <circle cx="12" cy="5" r="1"></circle>
                                <circle cx="12" cy="19" r="1"></circle>
                                </svg>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right bg-black" role="menu">
                                <a class="dropdown-item" href="/BTL/profile/${d.user.id}" data-abc="true">See detail </a><a class="dropdown-item download" data-abc="true">Contact </a><a class="dropdown-item edit" data-abc="true">Refuse</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item auctionWinner" data-abc="true" onclick="addAuctionWinner(${d.price},${d.user.id},${d.post.id}, '${d.user.email}')">Choose to win</a>
                            </div>
                        </div>
                    </div>
                </div>
            `;
                c.innerHTML = h;

                return h;
            }).then(() => callback());
}

async function loadAuctionWinner(endpointAuctionWinner, callback) {
    fetch(endpointAuctionWinner).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.log(data);
        let c = document.getElementById("sortable2");
        let h = '';
        for (let d of data)
            h += `
                <div class="list-item" data-id="3" data-item-sortable-id="0" draggable="true" role="option" aria-grabbed="false">
                    <div><a href="/BTL/profile/${d.user.id}" data-abc="true"><span class="w-40 avatar gd-primary"><img src="${d.user.avatar}" alt="." style="
                                 width: 37px;
                                 height: 37px;
                                 border-radius: 50%;
                                 "></span></a></div>
                        <div class="flex">
                            <a href="/BTL/profile/${d.user.id}" class="item-author text-color" data-abc="true">${d.user.firstName} ${d.user.lastName}</a>
                            <div class="item-except text-muted text-sm h-1x" title="email: ${d.user.email} and Phone: ${d.user.phone} " data-email="${d.user.email}">
                                <strong>email</strong>: ${d.user.email} <strong>|</strong> <strong>phone</strong>: ${d.user.phone}
                            </div>
                        </div>
                        <div class="no-wrap">
                        <div class="item-date text-muted text-sm d-none d-md-block"><strong>Mức giá đưa ra:</strong> ${d.price}</div>
                    </div>
                    <div>
                        <div class="item-action dropdown">
                            <a href="#" data-toggle="dropdown" class="text-muted" data-abc="true">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">
                                <circle cx="12" cy="12" r="1"></circle>
                                <circle cx="12" cy="5" r="1"></circle>
                                <circle cx="12" cy="19" r="1"></circle>
                                </svg>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right bg-black" role="menu">
                                <a class="dropdown-item" href="/BTL/profile/${d.user.id}" data-abc="true">See detail </a><a href="#" class="dropdown-item download" data-abc="true">Contact </a><a class="dropdown-item edit" data-abc="true">Refuse</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item auctionWinner" data-abc="true">Choose to win</a>
                            </div>
                        </div>
                    </div>
                </div>
            `;
        c.innerHTML = h;

    }).then(() => callback());
}

function addComment(endpoint, postId) {
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "comment": document.getElementById("commentId").value,
            "postId": postId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.querySelector("#comments li:first-child");
        let h = `
                <li class="list-group-item">${data.content} - binh luan boi ${data.user.username} - ${moment(data.createdDate).locale("vi").fromNow()}</li>
            `;

        d.insertAdjacentHTML("beforebegin", h);
        console.info(data);
    });
}

function addReport(endpoint, userReport) {
//    event.preventDefault();
    fetch(endpoint, {
        method: 'POST',
        body: JSON.stringify({
            "content": document.getElementById("reportId").value,
            "userReport": userReport
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    });
}


function addAuction(endpoint, postId, price) {
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "price": price,
            "postId": postId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let d = data;
        let c = document.getElementById("sortable");
        let h = `
                <div class="list-item" data-id="3" data-item-sortable-id="0" draggable="true" role="option" aria-grabbed="false">
                    <div><a href="/BTL/profile/${d.user.id}" data-abc="true"><span class="w-40 avatar gd-primary"><img src="${d.user.avatar}" alt="." style="
                                 width: 37px;
                                 height: 37px;
                                 border-radius: 50%;
                                 "></span></a></div>
                        <div class="flex">
                            <a href="/BTL/profile/${d.user.id}" class="item-author text-color" data-abc="true">${d.user.firstName} ${d.user.lastName}</a>
                            <div class="item-except text-muted text-sm h-1x" title="email: ${d.user.email} and Phone: ${d.user.phone}">
                                <strong>email</strong>: ${d.user.email} <strong>|</strong> <strong>phone</strong>: ${d.user.phone}
                            </div>
                        </div>
                        <div class="no-wrap">
                        <div class="item-date text-muted text-sm d-none d-md-block"><strong>Mức giá đưa ra:</strong> ${d.price}</div>
                    </div>
                    <div>
                        <div class="item-action dropdown">
                            <a href="#" data-toggle="dropdown" class="text-muted" data-abc="true">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical">
                                <circle cx="12" cy="12" r="1"></circle>
                                <circle cx="12" cy="5" r="1"></circle>
                                <circle cx="12" cy="19" r="1"></circle>
                                </svg>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right bg-black" role="menu">
                                <a class="dropdown-item" href="/BTL/profile/${d.user.id}" data-abc="true">See detail </a><a class="dropdown-item download" data-abc="true">Contact </a><a class="dropdown-item edit" data-abc="true">Refuse</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item auctionWinner" data-abc="true">Choose to win</a>
                            </div>
                        </div>
                    </div>
                </div>
            `;

        c.insertAdjacentHTML("beforeend", h);
    });
}

function addAuctionWinner(price, userid, postid, email) {
    fetch(`http://localhost:8080/BTL/api/post/${postid}/auctionWinner`, {
        method: 'post',
        body: JSON.stringify({
            "price": price,
            "postId": postid,
            "userId": userid,
            "email": email
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        window.location.reload();
    }
    );
}

function addNotification(endpoint, id, msg) {
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "msg": msg,
            "userId": id
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => {
        return res.json();
    }).then((data) => {
        console.log(data);
    });
}

function loadNotification(endpoint) {
    
    let reset = document.getElementById("notiBox-box");
    let child = reset.lastElementChild;
    while (child) {
        reset.removeChild(child);
        child = reset.lastElementChild;
    }
    
    fetch(endpoint).then((res) => {
        return res.json();
    }).then((data) => {
        console.log(data);
        let c = document.getElementById("notiBox-box");
        let h = '';
        for (let d of data)
            h += `
                <li>${d.message}</li>
            `;
        c.insertAdjacentHTML("beforeend", h);
    });
}

