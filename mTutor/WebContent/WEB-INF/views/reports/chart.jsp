
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="test" uri="/WEB-INF/tags/topicDescriptor.tld"%>
    <%@taglib prefix="subject" uri="/WEB-INF/tags/subjectDescriptor.tld"%>
    
    <script type="text/javascript" src="<c:url value="/resources/jquery/1.8/jquery-­1.8.0.min.js" />"></script>
   <script src="<c:url value="/resources/js/highcharts.js" />" type="text/javascript"></script>
  
  
  <script type="text/javascript" src="<c:url value="/resources/js/themes/gray.js" />"></script>
    
    
    
    <script>
    var chart1; // globally available
    $(document).ready(function() {
          chart1 = new Highcharts.Chart({
             chart: {
                renderTo: 'container',
                type: 'bar'
             },
             title: {
                text: 'Fruit Consumption'
             },
             xAxis: {
                categories: ['Apples', 'Bananas', 'Oranges']
             },
             yAxis: {
                title: {
                   text: 'Fruit eaten'
                }
             },
             series: [{
                name: 'Jane',
                data: [1, 0, 4]
             }, {
                name: 'John',
                data: [5, 7, 3]
             }]
          });
       });
    </script>
    
    
    <div id="container" style="width: 100%; height: 400px"></div>
    
    

      
                        




