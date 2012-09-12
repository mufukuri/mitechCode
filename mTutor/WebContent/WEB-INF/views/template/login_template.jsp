<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>mTutor - Login Page</title>
        <!-- Bootstrap framework -->
            <link rel="stylesheet" href="<c:url value="/statics/bootstrap/css/bootstrap.min.css" />" />
            <link rel="stylesheet" href="<c:url value="/statics/bootstrap/css/bootstrap-responsive.min.css" />" />
        <!-- theme color-->
            <link rel="stylesheet" href="<c:url value="/statics/css/blue.css" />" />
        <!-- tooltip -->    
			<link rel="stylesheet" href="<c:url value="/statics/lib/qtip2/jquery.qtip.min.css" />" />
        <!-- main styles -->
            <link rel="stylesheet" href="<c:url value="/statics/css/style.css" />" />
    
        <!-- Favicons and the like (avoid using transparent .png) -->
            <link rel="shortcut icon" href="<c:url value="/statics/favicon.ico" />" />
            <link rel="apple-touch-icon-precomposed" href="<c:url value="/statics/icon.png" />" />
    
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
    
        <!--[if lte IE 8]>
            <script src="<c:url value="/statics/js/ie/html5.js"></script>
			<script src="<c:url value="/statics/js/ie/respond.min.js"></script>
        <![endif]-->
		
    </head>
    <body class="login_page">
    
    <tiles:insertAttribute name="content"/>
    
    <script src="<c:url value="/statics/js/jquery.min.js" />"></script>
        <script src="<c:url value="/statics/js/jquery.actual.min.js" />"></script>
        <script src="<c:url value="/statics/lib/validation/jquery.validate.min.js" />"></script>
		<script src="<c:url value="/statics/bootstrap/js/bootstrap.min.js" />"></script>
        <script>
            $(document).ready(function(){
                
				//* boxes animation
				form_wrapper = $('.login_box');
                $('.linkform a,.link_reg a').on('click',function(e){
					var target	= $(this).attr('href'),
						target_height = $(target).actual('height');
					$(form_wrapper).css({
						'height'		: form_wrapper.height()
					});	
					$(form_wrapper.find('form:visible')).fadeOut(400,function(){
						form_wrapper.stop().animate({
                            height	: target_height
                        },500,function(){
                            $(target).fadeIn(400);
                            $('.links_btm .linkform').toggle();
							$(form_wrapper).css({
								'height'		: ''
							});	
                        });
					});
					e.preventDefault();
				});
				
				//* validation
				$('#login_form').validate({
					onkeyup: false,
					errorClass: 'error',
					validClass: 'valid',
					rules: {
						username: { required: true, minlength: 3 },
						password: { required: true, minlength: 3 }
					},
					highlight: function(element) {
						$(element).closest('div').addClass("f_error");
					},
					unhighlight: function(element) {
						$(element).closest('div').removeClass("f_error");
					},
					errorPlacement: function(error, element) {
						$(element).closest('div').append(error);
					}
				});
            });
        </script>
    </body>
</html>
    