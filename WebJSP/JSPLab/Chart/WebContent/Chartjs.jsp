<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
	
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.css"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script> -->
	
	<script type="text/javascript">
		$(function(){
			$('#chbtn').hide();
			var ajaxkey = {
				key : "008e51c5bfc624575cfa9d926bc6fc10",
				targetDt : "20191106",
			};
			
			var salesAcc = [];
			var	movieNm = [];
			
			$.ajax({
				url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
				type : "GET",
				datatype : "JSON",
				data : ajaxkey,
				success : function(data){//서버에서 받은 응답이 정상이라면.. 4 + 200~299
					//console.log(data);
					//console.log(data.boxOfficeResult.dailyBoxOfficeList);
					$.each(data.boxOfficeResult.dailyBoxOfficeList, function(index, element){
						//console.log(element.movieNm);
						//console.log(element.salesAcc);
						salesAcc.push(element.salesAcc);
						movieNm.push(element.movieNm);
						
						$('#chbtn').slideDown();
					});
				},
				error : function(xhr){ //서버에서 받은 응답이 Error 404, 500 등
					alert(xhr.status);
				}
			});
			
			console.log(salesAcc);
			console.log(movieNm);
			
			var chartdata = {
					datasets : [{
						label: '일별 박스오피스 누적매출현황',
						data : salesAcc,
						backgroundColor: [
							'rgba(243,97,166,0.8)', //1
							'rgba(153,0,76,0.8)', //2
							'rgba(67,116,217,0.8)', //3
							'rgba(178,204,255,0.8)', //4
							'rgba(83,183,75,0.8)', //5
							'rgba(188,229,92,0.8)', //6
							'rgba(228,247,186,0.8)', //7
							'rgba(255,220,115,0.8)', //8
							'rgba(255,255,54,0.8)', //9
						]
						/* borderColor: [
			                'rgba(255, 99, 132, 1)',
			                'rgba(54, 162, 235, 1)',
			                'rgba(255, 206, 86, 1)',
			                'rgba(75, 192, 192, 1)',
			                'rgba(153, 102, 255, 1)',
			                'rgba(255, 159, 64, 1)'
			            ],
			            borderWidth: 1 */
					}],
					labels : movieNm,
			};
			
			var ctx = document.getElementById('myChart').getContext('2d');
			
			$('#chbtn').click(function() {
				$('#chbtn').hide();
				// And for a doughnut chart
				var myDoughnutChart = new Chart(ctx, {
				    type: 'doughnut',
				    data: chartdata,
				    options: {
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero: true
				                }
				            }]
				        }
				    }
				});
			});

		});
	</script>
</head>
<body>
	<button id="chbtn">챠트볼래?</button>
	<div style="width:500px;height:500px;">
		<canvas id="myChart" style="width:400px; height:400px;"></canvas>
	</div>
</body>
<style>
	
</style>
</html>