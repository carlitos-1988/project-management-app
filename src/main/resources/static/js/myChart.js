var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);


var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].countOfStatus;
	labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Project Statuses'
    	}

    }
});

// "[{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}

//---------------------------
//
//console.log(chartData);
//
//var chartDataStr = decodeHtml(chartData);
//console.log(chartDataStr);
//
////var charMiddle = JSON.stringify(chartDataStr)
//
//var chartJsonArray = JSON.parse(chartData);
//console.log(chartJsonArray);
//
//
//
//var arrayLength = chartJsonArray.length;
//
//var numericData = [];
//var labelData = [];
//
//for(var i = 0; i < arrayLength; i++){
//    numericData[i] = chartJsonArray[i].countOfStatus;
//    labelData[i] = chartJsonArray[i].label;
//    console.log(numericData[i] + "-"+ labelData[i]);
//};
//
//
//
//
//
//const ctx = document.getElementById("myChart");
//
//  new Chart(ctx, {
//    type: "pie",
//    data: {
//      labels: labelData,
//      datasets: [{
//        label: "My First dataset",
//        backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
//        data: numericData
//      }]
//    },
//    options: {
//      title: {
//        display:true,
//        text: "Project Statuses"
//      }
//    }
//  });
//
//
//
//  function decodeHtml(html){
//   let txt = document.createElement("textArea");
//   txt.innerHTML = html;
//   return txt.value;
//  }