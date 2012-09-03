<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript">
$(document).ready(function () {
    var n = 1;
    $('#more').click(function(){
        n++;
        $('#files').append("<br/><input type=\"file\" name=\"file" + n +"\" id=\"file" + n + "\" />");
    });
});
</script>
<spring:url value="/mvc/user/uploadfile" var="upload_file"/>
<form action="${upload_file}" method="post" enctype="multipart/form-data">
   <fieldset class="ui-widget ui-widget-content">
    <legend class="ui-widget-header ui-corner-all"><span>Upload CSV</span></legend>
        <div class="field" id="files">
            <input type="file" name="file1" id="file1" />
        </div>
        <input type="button" value="Other File" id="more" name="more" /><br/><br/>
        <div class="field">
            <input type="submit" value="Upload File" />
        </div>
   </fieldset>
</form>