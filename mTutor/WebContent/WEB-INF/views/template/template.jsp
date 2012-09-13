<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>:: Mtutor :: Learning outside the box </title>
    	<script  src="<c:url value="/statics/js/jquery.min.js" />"></script>
			
        <!-- Bootstrap framework -->
            <link rel="stylesheet" href="<c:url value="/statics/bootstrap/css/bootstrap.min.css" />" />
            <link rel="stylesheet" href="<c:url value="/statics/bootstrap/css/bootstrap-responsive.min.css" />" />
        <!-- gebo blue theme-->
            <link rel="stylesheet" href="<c:url value="/statics/css/blue.css" />" id="link_theme" />
        <!-- breadcrumbs-->
            <link rel="stylesheet" href="<c:url value="/statics/lib/jBreadcrumbs/css/BreadCrumb.css" />" />
        <!-- tooltips-->
            <link rel="stylesheet" href="<c:url value="/statics/lib/qtip2/jquery.qtip.min.css" />" />
        <!-- colorbox -->
            <link rel="stylesheet" href="<c:url value="/statics/lib/colorbox/colorbox.css" />" />    
        <!-- code prettify -->
            <link rel="stylesheet" href="<c:url value="/statics/lib/google-code-prettify/prettify.css" />" />    
        <!-- notifications -->
            <link rel="stylesheet" href="<c:url value="/statics/lib/sticky/sticky.css" />" />    
        <!-- splashy icons -->
            <link rel="stylesheet" href="<c:url value="/statics/img/splashy/splashy.css" />" />
		<!-- flags -->
            <link rel="stylesheet" href="<c:url value="/statics/img/flags/flags.css" />" />	
		<!-- calendar -->
            <link rel="stylesheet" href="<c:url value="/statics/lib/fullcalendar/fullcalendar_gebo.css" />" />
            
        <!-- main styles -->
            <link rel="stylesheet" href="<c:url value="/statics/css/style.css" />" />
			
            
        <!-- Favicon -->
            <link rel="shortcut icon" href="favicon.ico" />
		
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="<c:url value="/statics/css/ie.css" />
            <script  src="<c:url value="/statics/js/ie/html5.js" />"></script>
			<script  src="<c:url value="/statics/js/ie/respond.min.js" />"></script>
			<script  src="<c:url value="/statics/lib/flot/excanvas.min.js" />"></script>
        <![endif]-->
		
		<script>
			//* hide all elements & show preloader
			document.documentElement.className += 'js';
		</script>
    </head>
    <body>
		<div id="loading_layer" style="display:none"><img src="<c:url value="/statics/img/ajax_loader.gif" />" alt="" /></div>
	
		
		<div id="maincontainer" class="clearfix" >
			<!-- header -->
            <header>
				<div style="z-index:5000;position :fixed;top:0;left:25px"><img src="<c:url value="/statics/img/mtutor.png" />"/></div>
                   
                <div class="navbar navbar-fixed-top" >
					
                    <div class="navbar-inner">
					     <div class="container-fluid">
						
                            <a class="brand" href="#">&nbsp;</a>
                            <ul class="nav user_menu pull-right">
								<li class="divider-vertical hidden-phone hidden-tablet"></li>
                                
                                <li class="divider-vertical hidden-phone hidden-tablet"></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Prince Kaguda <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
										<li><a href="user_profile.html">Change Password</a></li>
										<li class="divider"></li>
										<li><a href="login.html">Log Out</a></li>
                                    </ul>
                                </li>
                            </ul>
							<a data-target=".nav-collapse" data-toggle="collapse" class="btn_menu">
								<span class="icon-align-justify icon-white"></span>
							</a>
                            <nav>
                                <div class="nav-collapse">
                                    <ul class="nav">
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-list-alt icon-white"></i> Schools <b class="caret"></b></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="form_elements.html">New School</a></li>
                                                <li><a href="form_extended.html">View Schools</a></li>
                                            </ul>
                                        </li>
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-th icon-white"></i> Teachers <b class="caret"></b></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="alerts_btns.html">New Teacher</a></li>
                                                <li><a href="icons.html">Transfer Teacher</a></li>
                                                <li><a href="notifications.html">View Teachers</a></li>

                                            </ul>
                                        </li>
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-wrench icon-white"></i> Settings <b class="caret"></b></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="charts.html">Subjects</a></li>
                                                <li><a href="/mTutor/topics?new">Add Topic</a></li>
                                                <li><a href="/mTutor/concepts?new">Add Concepts</a></li>
                                                <li><a href="/mTutor/addQuiz">Add Quiz</a></li>
                                                
                                            </ul>
                                        </li>
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-user icon-white"></i> Users <b class="caret"></b></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="chat.html">New User</a></li>
                                                <li><a href="error_404.html">View Users</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                        </li>
                                    </ul>
                                </div>
                            </nav>
							
                        </div>
						
                    </div>
                </div>
                
            </header>
            
            <!-- main content -->
            <div id="contentwrapper">
                <div class="main_content">
               	<tiles:insertAttribute name="content"/>
               </div>
            </div>
            
			<!-- sidebar -->
           <div class="sidebar" style="top: 100px">
				
				<div class="antiScroll">
					<div class="antiscroll-inner">
						<div class="antiscroll-content">
					
							<div class="sidebar_inner">
								<form action="index.php?uid=1&amp;page=search_page" class="input-append" method="post" >
									<input autocomplete="off" name="query" class="search_query input-medium" size="16" type="text" placeholder="Search..." /><button type="submit" class="btn"><i class="icon-search"></i></button>
								</form>
								<div id="side_accordion" class="accordion">
									
									<div class="accordion-group">
										<div class="accordion-heading">
											<a href="#collapseOne" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-folder-close"></i> Quiz
											</a>
										</div>
										<div class="accordion-body collapse" id="collapseOne">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li><a href="javascript:void(0)">Articles</a></li>
													<li><a href="javascript:void(0)">News</a></li>
													<li><a href="javascript:void(0)">Newsletters</a></li>
													<li><a href="javascript:void(0)">Comments</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="accordion-group">
										<div class="accordion-heading">
											<a href="#collapseTwo" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-th"></i> Questions
											</a>
										</div>
										<div class="accordion-body collapse" id="collapseTwo">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li><a href="javascript:void(0)">Content blocks</a></li>
													<li><a href="javascript:void(0)">Tags</a></li>
													<li><a href="javascript:void(0)">Blog</a></li>
													<li><a href="javascript:void(0)">FAQ</a></li>
													<li><a href="javascript:void(0)">Formbuilder</a></li>
													<li><a href="javascript:void(0)">Location</a></li>
													<li><a href="javascript:void(0)">Profiles</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="accordion-group">
										<div class="accordion-heading">
											<a href="#collapseThree" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-user"></i>Classes
											</a>
										</div>
										<div class="accordion-body collapse" id="collapseThree">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li><a href="javascript:void(0)">Members</a></li>
													<li><a href="javascript:void(0)">Members groups</a></li>
													<li><a href="javascript:void(0)">Users</a></li>
													<li><a href="javascript:void(0)">Users groups</a></li>
												</ul>
												
											</div>
										</div>
									</div>
									<div class="accordion-group">
										<div class="accordion-heading">
											<a  href="#collapseFour" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-list"></i> Simulator
											</a>
										</div>
										<div class="accordion-body collapse in" id="collapseFour">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													
													<li class="active"><a href="/mTutor/sim/page">Simulator</a></li>
													
												</ul>
											</div>
										</div>
									</div>
									
									<div class="accordion-group">
										<div class="accordion-heading">
											<a href="#collapseFive" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
												<i class="icon-file"></i>Reports
											</a>
										</div>
										<div class="accordion-body collapse" id="collapseFive">
											<div class="accordion-inner">
												<ul class="nav nav-list">
													<li><a href="/mTutor/demo?studentReport">Class Report</a></li>
													<li><a href="javascript:void(0)">School Report</a></li>
												</ul>
												
											</div>
										</div>
									</div>
									
									
								</div>
								
								<div class="push"></div>
							</div>
							   
							
						
						</div>
					</div>
				</div>
			
			</div>
            
           <!-- smart resize event -->
			<script  src="<c:url value="/statics/js/jquery.debouncedresize.min.js" />"></script>
			<!-- hidden elements width/height -->
			<script  src="<c:url value="/statics/js/jquery.actual.min.js" />"></script>
			<!-- js cookie plugin -->
			<script  src="<c:url value="/statics/js/jquery.cookie.min.js" />"></script>
			<!-- main bootstrap js -->
			<script  src="<c:url value="/statics/bootstrap/js/bootstrap.min.js" />"></script>
			<!-- tooltips -->
			<script  src="<c:url value="/statics/lib/qtip2/jquery.qtip.min.js" />"></script>
			<!-- jBreadcrumbs -->
			<script  src="<c:url value="/statics/lib/jBreadcrumbs/js/jquery.jBreadCrumb.1.1.min.js" />"></script>
			<!-- lightbox -->
            <script  src="<c:url value="/statics/lib/colorbox/jquery.colorbox.min.js" />"></script>
            <!-- fix for ios orientation change -->
			<script  src="<c:url value="/statics/js/ios-orientationchange-fix.js" />"></script>
			<!-- scrollbar -->
			<script  src="<c:url value="/statics/lib/antiscroll/antiscroll.js" />"></script>
			<script  src="<c:url value="/statics/lib/antiscroll/jquery-mousewheel.js" />"></script>
			<!-- common functions -->
			<script  src="<c:url value="/statics/js/gebo_common.js" />"></script>
			
			<script  src="<c:url value="/statics/lib/jquery-ui/jquery-ui-1.8.20.custom.min.js" />"></script>
            <!-- touch events for jquery ui-->
            <script  src="<c:url value="/statics/js/forms/jquery.ui.touch-punch.min.js" />"></script>
            <!-- multi-column layout -->
            <script  src="<c:url value="/statics/js/jquery.imagesloaded.min.js" />"></script>
            <script  src="<c:url value="/statics/js/jquery.wookmark.js" />"></script>
            <!-- responsive table -->
            <script  src="<c:url value="/statics/js/jquery.mediaTable.min.js" />"></script>
           
            <!-- charts -->
         
         
            
            <!-- datatable -->
            <script src="<c:url value="/statics/lib/datatables/jquery.dataTables.min.js" />"></script>
            <script src="<c:url value="/statics/lib/datatables/extras/Scroller/media/js/Scroller.min.js" />"></script>
            <!-- datatable functions -->
            <script src="<c:url value="/statics/js/gebo_datatables.js" />"></script>
          
            <!-- sortable/filterable list -->
            <script  src="<c:url value="/statics/lib/list_js/list.min.js" />"></script>
            <script  src="<c:url value="/statics/lib/list_js/plugins/paging/list.paging.min.js" />"></script>
            
    		<script src="<c:url value="/statics/js/highcharts.js" />"></script>
			<script src="<c:url value="/statics/js/modules/exporting.js" />"></script>
			<script>
				$(document).ready(function() {
					//* show all elements & remove preloader
					setTimeout('$("html").removeClass("js")',1000);
				});
			</script>
		
		</div>
	</body>
</html>