
function setWebhook() {
  var url = TELEGRAM_URL + "/setWebhook?url=" + WEBAPP_URL;
  fetchAndLog(url);
}

function fetchAndLog(url){
  var response = UrlFetchApp.fetch(url);
  Logger.log(response.getContentText());
}

function sendMessage(receiverID, txtMessage){
  var url = TELEGRAM_URL + "/sendMessage?chat_id=" + receiverID + "&text=" + encodeURIComponent(txtMessage);
  fetchAndLog(url);
}

function copyMessage(senderID, messageID, recieverID){
  var url = TELEGRAM_URL + "/copyMessage?chat_id=" + recieverID + "&from_chat_id=" + senderID + "&message_id=" + messageID;
  fetchAndLog(url);
}

function forwardMessage(senderID, messageID, recieverID){
  var url = TELEGRAM_URL + "/forwardMessage?chat_id=" + recieverID + "&from_chat_id=" + senderID + "&message_id=" + messageID;
  fetchAndLog(url);
}

function sendSticker(chat_id, sticker_file_id) {
  var url = "https://api.telegram.org/bot" + TOKEN + "/sendSticker";
  var payload = {
    chat_id: chat_id,
    sticker: sticker_file_id
  };
  var options = {
    method: "post",
    contentType: "application/json",
    payload: JSON.stringify(payload)
  };
  UrlFetchApp.fetch(url, options);
}

function sendVideoMessage(chat_id, file_id_or_blob) {
  var url = TELEGRAM_URL + "/sendVideoNote";

  var payload = {
    chat_id: chat_id,
    video_note: file_id_or_blob
  };

  var options = {
    method: "post",
    contentType: "application/json",
    payload: JSON.stringify(payload)
  };

  var response = UrlFetchApp.fetch(url, options);
  Logger.log(response.getContentText());
}
function sendGif(chat_id, gif_file_id_or_url) {
  var url = "https://api.telegram.org/bot" + TOKEN + "/sendAnimation";
  var payload = {
    chat_id: chat_id,
    animation: gif_file_id_or_url
  };
  var options = {
    method: "post",
    contentType: "application/json",
    payload: JSON.stringify(payload)
  };
  UrlFetchApp.fetch(url, options);
}
function sendVoice(chat_id, voice_file_id_or_url) {
  var url = "https://api.telegram.org/bot" + TOKEN + "/sendVoice";
  var payload = {
    chat_id: chat_id,
    voice: voice_file_id_or_url
  };
  var options = {
    method: "post",
    contentType: "application/json",
    payload: JSON.stringify(payload)
  };
  UrlFetchApp.fetch(url, options);
}
function sendVideo(chat_id, video_file_id_or_url) {
  var url = "https://api.telegram.org/bot" + TOKEN + "/sendVideo";
  var payload = {
    chat_id: chat_id,
    video: video_file_id_or_url
  };
  var options = {
    method: "post",
    contentType: "application/json",
    payload: JSON.stringify(payload)
  };
  UrlFetchApp.fetch(url, options);
}
function sendReply(chat_id, message_id, text) {
  var url = "https://api.telegram.org/bot" + TOKEN + "/sendMessage";
  var payload = {
    chat_id: chat_id,
    text: text,
    reply_to_message_id: message_id
  };
  var options = {
    method: "post",
    contentType: "application/json",
    payload: JSON.stringify(payload)
  };
  UrlFetchApp.fetch(url, options);
}
function sendPhoto(chat_id, photo_file_id) {
  var url = "https://api.telegram.org/bot" + TOKEN + "/sendPhoto";
  var payload = {
    chat_id: chat_id,
    photo: photo_file_id
  };
  var options = {
    method: "post",
    contentType: "application/json",
    payload: JSON.stringify(payload)
  };
  UrlFetchApp.fetch(url, options);
}
function getViCountdown() {
  var targetDate = new Date("2026-05-26"); 
  var today = new Date();

  targetDate.setHours(0, 0, 0, 0);
  today.setHours(0, 0, 0, 0);

  var diffTime = targetDate - today;
  var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

  return diffDays;
}

