<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="newAPI" value="/api/new"></c:url>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach"></c:url>
<c:url var="editURL" value="/quan-tri/bai-viet/chinh-sua"></c:url>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>

                <li>
                    <a href="#">Forms</a>
                </li>
                <li class="active">Form Elements</li>
            </ul><!-- /.breadcrumb -->

        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}" >
                        <div class="alert alert-${alert}">
                            ${message}
                        </div>
                    </c:if>

                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="categoryCode">Chọn thể loại:</label>
                            <div class="col-sm-9">
                                <form:select class="form-control" id="categoryCode" path="categoryCode">
                                    <form:option value="" label="-- Chọn thể loại -- "></form:option>
                                    <form:options items="${categories}"></form:options>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="title"> Tên bài viết</label>

                            <div class="col-sm-9">
                                <form:input path="title" cssClass="col-xs-10 col-sm-5" id="title"></form:input>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="thumbnail">Ảnh đại diện</label>

                            <div class="col-sm-9">
                                <input type="file" class="col-xs-10 col-sm-5" id="thumbnail" name="thumbnail"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="shortDescription">Mô tả ngắn:</label>

                            <div class="col-sm-9">
                                <form:textarea path="shortDescription" id="shortDescription" cssClass="form-control" rows="5" cols="10"></form:textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="content">Nội dung:</label>

                            <div class="col-sm-9">
                                <form:textarea path="content" id="content" cssClass="form-control" rows="5" cols="10"></form:textarea>
                            </div>
                        </div>

                        <form:hidden path="id" id="newId"/>

                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Cập nhật bài viết
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Thêm bài viết
                                    </button>
                                </c:if>

                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Hủy
                                </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var editor = '';
    editor = CKEDITOR.replace('content');
    // $(document).ready(function () {
    //
    // });

    $('#btnAddOrUpdateNew').click(function (e){
       e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        data["content"] = editor.getData();

        var id = $('#newId').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data)
        }
    });

    function addNew(data) {
        $.ajax({
            url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result){
                window.location.href = "${editURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error){
                window.location.href = '${newURL}?page=1&limit=2&message=error_system';
            }
        });
    }

    function updateNew(data) {
        $.ajax({
            url: '${newAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result){
                window.location.href = "${editURL}?id="+result.id+"&message=update_success";
            },
            error: function (error){
                window.location.href = "${editURL}?id="+error.id+"&message=error_system";
            }
        });
    }
</script>
</body>
</html>
