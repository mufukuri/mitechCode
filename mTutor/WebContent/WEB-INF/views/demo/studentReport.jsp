<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'summary',
                type: 'bar'
            },
            title: {
                text: 'Class Performance'
            },
            
            xAxis: {
                categories: ['0-20', '21-40', '41-60', '61-80', '81-100'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Number of students',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            tooltip: {
                formatter: function() {
                    return ''+
                        this.series.name +': '+ this.y +' students';
                }
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -100,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: '#FFFFFF',
                shadow: true
            },
            credits: {
                enabled: false
            },
            series: [{
                name: 'Maths',
                data: [0, 1, 2, 3, 2]
            }]
        });
    });
    
});
		</script>
    
 <div class="row-fluid">
 	<div class="span4">
 	<h3 class="heading">Class Summary</h3>
 	<table class="table table-striped">
 		<tr>
 			<td>Class</td>
 			<td>7 Blue</td>
 		</tr>
 		
 		<tr>
 			<td>Subject</td>
 			<td>Maths</td>
 		</tr>
 		
 		<tr>
 			<td>Class Average</td>
 			<td>64%</td>
 		</tr>
 		
 		<tr>
 			<td>Highest Score</td>
 			<td>90%</td>
 		</tr>
 		
 		<tr>
 			<td>Lowest Score</td>
 			<td>36%</td>
 		</tr>
 		
 	</table>
 	</div>
 	<div class="span8">
 		<div id="summary"></div>
 	</div>
 </div>
    
 <div class="row-fluid">
                        <div class="span12">
                            <h3 class="heading">Score Sheet</h3>
                            <table class="table table-striped table-bordered dTableR" id="dt_a">
                                <thead>
                                    <tr>
                                        <th>Position</th>
                                        <th>Student</th>
                                        <th>Quiz Attempted</th>
                                        <th>Correct Questions</th>
                                        <th>Total</th>
                                        <th>Mark</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Kaguda Prince</td>
                                        <td class="center">5</td>
                                        <td class="center">45</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-success sl_status"><b>90%</b></span></td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Chifetete Douglas</td>
                                        <td class="center">5</td>
                                        <td class="center">42</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-success sl_status"><b>84%</b></span></td>
                                    </tr>
                                    <tr>
                                         <td>3</td>
                                        <td>Gambanga Nigel</td>
                                        <td class="center">5</td>
                                        <td class="center">34</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-success sl_status"><b>68%</b></span></td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>Nyamweda Tendai</td>
                                        <td class="center">5</td>
                                        <td class="center">34</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-success sl_status"><b>68%</b></span></td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>Gwokuda Fidelis</td>
                                        <td class="center">5</td>
                                        <td class="center">31</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-success sl_status"><b>62%</b></span></td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>Bonde Blessing</td>
                                        <td class="center">5</td>
                                        <td class="center">29</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-success sl_status"><b>58%</b></span></td>
                                    </tr>
                                    <tr>
                                        <td>7</td>
                                        <td>Zulu Ozwin</td>
                                        <td class="center">5</td>
                                        <td class="center">23</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-important sl_status"><b>46%</b></span></td>
                                    </tr>
                                    <tr>
                                         <td>8</td>
                                        <td>Moyo Mthulisi</td>
                                        <td class="center">5</td>
                                        <td class="center">18</td>
                                        <td class="center">50</td>
                                        <td class="center"><span class="label label-important sl_status"><b>36%</b></span></td>
                                    </tr>
                                  
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
			