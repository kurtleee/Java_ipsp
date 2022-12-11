function currentLineChart(el, currentData) {
	let myChart = echarts.init(el);
	let option = {
		title: {
			text: '今日数据',
			x: '10px',
			y: '10px',
			textStyle: {
				fontSize: 14
			}
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			x: 'right',
			y: '10px',
			data: ['注册量', '解析量'],
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				//saveAsImage: {}
			}
		},
		xAxis: {
			type: 'category',
			boundaryGap: true,
			data: ['8:00', '10:00', '12:00', '14:00', '16:00', '18:00', '20:00']
		},
		yAxis: {
			type: 'value'
		},
		series: [{
				name: '注册量',
				type: 'line',
				data: currentData.registers
			},
			{
				name: '解析量',
				type: 'line',
				data: currentData.parses
			}
		]
	};
	myChart.setOption(option);
}

function historyLineChart(el, data) {
	let myChart = echarts.init(el);
	let option = {
		title: {
			text: '历史数据',
			x: '10px',
			y: '10px',
			textStyle: {
				fontSize: 14
			}
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			x: 'right',
			y: '10px',
			data: ['注册量', '解析量'],
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		xAxis: {
			type: 'category',
			boundaryGap: true,
			data: ['6月', '7月', '8月', '9月', '10月', '11月']
		},
		yAxis: {
			type: 'value'
		},
		series: [{
				name: '注册量',
				type: 'line',
				data: data.registers
			},
			{
				name: '解析量',
				type: 'line',
				data: data.parses
			}
		]
	};
	myChart.setOption(option);
}

function registerPieChart(el, data) {
	let myChart = echarts.init(el)
	option = {
		title: {
			text: '注册量占比',
			left: '10px',
			top: '10px',
			/* y: '10px', */
			textStyle: {
				fontSize: 14
			}
		},
		tooltip: {
			trigger: 'item'
		},
		legend: {
			orient: 'horizontal',
			left: 'right',
			y: '10px',
		},
		series: [{
			name: '注册量占比',
			type: 'pie',
			center: ['50%', '55%'],
			radius: '80%',
			label: false,
			data: [
				{
					value: data.registerTotal,
					name: '注册量'
				},
				{
					value: data.visitTotal,
					name: '访问量'
				}
			],
			emphasis: {
				itemStyle: {
					shadowBlur: 10,
					shadowOffsetX: 0,
					shadowColor: 'rgba(0, 0, 0, 0.5)'
				}
			}
		}]
	}
	myChart.setOption(option)
}
