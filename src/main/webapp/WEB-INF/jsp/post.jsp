<%-- 
    Document   : post
    Created on : Aug 14, 2022, 8:29:26 PM
    Author     : LAPTOP MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/profile" var="action"/>
<c:if test="${param.error !=null}">
    <div class="alert alert-danger">
        Da co loi
    </div>
</c:if>
<script src="https://cdn01.jotfor.ms/static/prototype.forms.js?3.3.35224" type="text/javascript"></script>
<script src="https://cdn02.jotfor.ms/static/jotform.forms.js?3.3.35224" type="text/javascript"></script>
<script src="https://cdn03.jotfor.ms/js/vendor/imageinfo.js?v=3.3.35224" type="text/javascript"></script>
<script src="https://cdn01.jotfor.ms/file-uploader/fileuploader.js?v=3.3.35224"></script>

<style type="text/css">@media print{
        .form-section{
            display:inline!important
        }
        .form-pagebreak{
            display:none!important
        }
        .form-section-closed{
            height:auto!important
        }
        .page-section{
            position:initial!important
        }
    }</style>
<link type="text/css" rel="stylesheet" href="https://cdn01.jotfor.ms/themes/CSS/5e6b428acc8c4e222d1beb91.css?themeRevisionID=5f7ed99c2c2c7240ba580251"/>
<link type="text/css" rel="stylesheet" href="https://cdn02.jotfor.ms/css/styles/payment/payment_styles.css?3.3.35224" />
<link type="text/css" rel="stylesheet" href="https://cdn03.jotfor.ms/css/styles/payment/payment_feature.css?3.3.35224" />
<form class="jotform-form"  name="form_222262594019455" id="222262594019455" accept-charset="utf-8">
    <input type="hidden" name="formID" value="222262594019455" />
    <input type="hidden" id="JWTContainer" value="" />
    <input type="hidden" id="cardinalOrderNumber" value="" />
    <div role="main" class="form-all">
        <ul class="form-section page-section">
            <li id="cid_1" class="form-input-wide" data-type="control_head">
                <div class="form-header-group  header-large">
                    <div class="header-text httal htvam">
                        <h1 id="header_1" class="form-header" data-component="header">
                            THÊM BÀI VIẾT
                        </h1>
                    </div>
                </div>
            </li>
            <li class="form-line" data-type="control_textbox" id="id_9">
                <label class="form-label form-label-top form-label-auto" id="label_9" for="input_9"> TOPIC </label>
                <div id="cid_9" class="form-input-wide" data-layout="half">
                    <input type="text" id="topic" class="" name="q9_topic" data-type="input-textbox" class="form-textbox" data-defaultvalue="" style="width:310px" size="310" value="" data-component="textbox" aria-labelledby="label_9"/>
                </div>
            </li>
            <li class="form-line" data-type="control_fileupload" id="id_7">
                <label class="form-label form-label-top form-label-auto" id="label_7" for="input_7"> Upload Image </label>
                <div id="cid_7" class="form-input-wide" data-layout="full">
                    <div class="jfQuestion-fields" data-wrapper-react="true">
                        <div class="jfField isFilled">
                            <div class="jfUpload-wrapper">
                                <div class="jfUpload-container">
                                    <div class="jfUpload-text-container">
                                        <div class="jfUpload-icon forDesktop">
                                            <span class="iconSvg  dhtupload ">
                                                <svg viewBox="0 0 54 47" version="1.1" xmlns="http://www.w3.org/2000/svg">
                                                <g stroke="none" strokeWidth="1" fill="none">
                                                <g transform="translate(-1506.000000, -2713.000000)">
                                                <g transform="translate(1421.000000, 2713.000000)">

                                                </g>
                                                </g>
                                                </g>
                                                </svg>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="jfUpload-button-container">
                                        <div class="jfUpload-button" aria-hidden="true" tabindex="0" style="display:none" data-version="v2">
                                            Upload a File
                                            <div class="jfUpload-heading forDesktop">
                                                Drag and drop files here
                                            </div>
                                            <div class="jfUpload-heading forMobile">
                                                Choose a file
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="jfUpload-files-container">
                                    <input type="file" id="image"  name="q7_uploadImage[]" class="form-upload-multiple" data-imagevalidate="yes" data-file-accept="jpg, jpeg, png"  />
                                </div>
                            </div>
                            <div data-wrapper-react="true">
                            </div>
                        </div>
                        <span style="display:none" class="cancelText">
                            Cancel
                        </span>
                        <span style="display:none" class="ofText">
                            of
                        </span>
                    </div>
                </div>
            </li>
            <li class="form-line" data-type="control_textarea" id="id_6">
                <label class="form-label form-label-top form-label-auto" id="label_6" for="input_6"> Content </label>
                <div id="cid_6" class="form-input-wide" data-layout="full">
                    <textarea id="content" class="form-textarea"  name="q6_content" style="width:648px;height:163px" data-component="textarea" aria-labelledby="label_6"></textarea>
                </div>
            </li>
            <li class="form-line" data-type="control_button" id="id_2">
                <div id="cid_2" class="form-input-wide" data-layout="full">
                    <div data-align="auto" class="form-buttons-wrapper form-buttons-auto   jsTest-button-wrapperField">
                        <button id="input_2" type="button" onclick="addPost()"class="form-submit-button submit-button jf-form-buttons jsTest-submitField" data-component="button" data-content="">
                            Submit
                        </button>
                    </div>
                </div>
            </li>       
        </ul>
</form>
<script src="https://cdn.jotfor.ms//js/vendor/smoothscroll.min.js?v=3.3.35224"></script>
<script src="https://cdn.jotfor.ms//js/errorNavigation.js?v=3.3.35224"></script>

