/**
 * Author: Binay Mishra
 */

//Create stomp client over sockJS protocol
var socket = new SockJS("/stock-market");
var stompClient = Stomp.over(socket);

//Render price data from server into HTML, registered as callback
//when subscribing to price topic

function renderPrice(frame) {

  // List of price received from Websocket Connection
  var prices = JSON.parse(frame.body);

  $('#price').empty();

  for (var i in prices) {

    var price = prices[i];

    // RED color price.diff when less than 0.0
    if (price.diff.toFixed(2) <= 0.0) {

      $('#price').append(
          $('<tr>').append(
              $('<td>').html(price.name),
              $('<td>').html(price.oldPrice.toFixed(2)),
              $('<td>').html(price.price.toFixed(2)),
              $('<td style="color:#FF3633;font-weight:bold">').html(price.diff.toFixed(2))
          ));
    }

  // GREEN color price.diff
    else {
      $('#price').append(
          $('<tr>').append(
              $('<td>').html(price.name),
              $('<td>').html(price.oldPrice.toFixed(2)),
              $('<td>').html(price.price.toFixed(2)),
              $('<td style="color:#33FF52;font-weight:bold">').html(price.diff.toFixed(2))
          ));
    }
  }
}

// Callback function to be called when stomp client is connected to server
var connectCallback = function () {
  stompClient.subscribe('/topic/stock', renderPrice);
};

//Callback function to be called when stomp client could not connect to server
var errorCallback = function (error) {
  alert(error.headers.message);
};

// Connect to server via websocket
stompClient.connect("guest", "guest", connectCallback, errorCallback);