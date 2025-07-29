function myFunction() {
  var hash_value = simpleHash("سلام")
  var message = giveMessage(hash_value)
  Logger.log(hash_value)
  Logger.log(message)
}

function simpleHash(str) {
  var hash = 0;
  for (var i = 0; i < str.length; i++) {
    hash = (hash * 31 + str.charCodeAt(i)) & 0x7fffffff; 
  }
  return hash % 16;
}

function giveMessage(i){
  var spreadSheet = SpreadsheetApp.openById(SPREADSHEET_ID);
  var sheet = spreadSheet.getSheetByName("Messages");  
  var data = sheet.getDataRange().getValues();
  return data[i][0];
}

function register(sender_id, name, family, username){
  var spreadSheet = SpreadsheetApp.openById(SPREADSHEET_ID);
  var sheet = spreadSheet.getSheetByName("Users");
  var data = sheet.getDataRange().getValues();
  for(var i = 0; i < data.length; i++){
    if(data[i][0] == sender_id){
      return;
    }
  }
  sheet.appendRow([sender_id, name, family, username]);
}

function sendToAll(message = "سلام، ربات به روزرسانی شد."){
  var spreadSheet = SpreadsheetApp.openById(SPREADSHEET_ID);
  var sheet = spreadSheet.getSheetByName("Users");
  var data = sheet.getDataRange().getValues();
  for(var i = 1; i < data.length; i++){
    sendMessage(data[i][0], message)
  }
}

function doPost(e) {
  var contents = JSON.parse(e.postData.contents);
  
  var chat_id = contents.message.chat.id;  
  
  var sender_id = contents.message.from.id; 

  var text = contents.message.text;
// if (contents.message && contents.message.photo) {
//   var photos = contents.message.photo;
//   var lastPhoto = photos[photos.length - 1]; // بزرگ‌ترین سایز
//   var fileId = lastPhoto.file_id;
//   var chatId = contents.message.chat.id;

//   sendMessage(chatId, "آیدی عکس شما:\n" + fileId);
// }
  
  if(text) {
    if(text.includes(" شاهکار")){
      sendSticker(chat_id, "CAACAgQAAxkBAAMgaIFHWJyYRMnMPCzOSe3DRyfnKvUAAiAPAAJc1SlTMtqMjLN7l3g2BA")
    } else if(text.includes("جردن") || text.includes("مایکل")) {
      sendMessage(chat_id, "🐐")
    } else if(text.includes("خایه")) {
      sendMessage(chat_id, "خایه مال افریته یابو هول")
    } else if(text.includes("لبران")) {
      sendMessage(chat_id, "👑")
    } else if(text.includes("سینا") || text.includes("جعفر")) {
      sendMessage(chat_id, "💩")
    } else if(text.includes(" ماین") || text.includes(" ریپو")) {
      sendMessage(chat_id, "@wammad @SONRA0 @mahdi0x06")
    } else if(text.includes("دنور")) {
      sendMessage(chat_id, "سوییپ")
    } else if(text.includes("نود")) {
      sendMessage(chat_id, "@SONRA0")
    } else if(text.includes("اندی")) {
      sendVideoMessage(chat_id, "DQACAgQAAx0CZYq1EQABAmERaIFZzZzQEr0zd90Z9zBhKIBsQCUAAh4aAAKA6NlROPZRe1Xq-Zo2BA")
    } else if(text.includes("اسرائیل") || text.includes("اسراییل")) {
      sendMessage(chat_id, "صابون")
    } else if(text.includes("تکبیر")) {
      sendMessage(chat_id, `الله اکبر 
                            الله اکبر 
                            الله اکبر 
                            خامنه ای رهبر      
                            مرگ بر ضد ولایت فقیه      
                            مرگ بر آمریکا 
                            مرگ بر انگلیس 
                            مرگ بر منافقین و کفار 
                            مرگگگگگ بر اسرائیل`);
    } else if(text.includes("سوپرایز")) {
      sendGif(chat_id, "CgACAgQAAx0CZYq1EQABAqFuaIFKlrxzyAGJ7v46ljpFzQ_LuOoAAnIXAAIInlBRtOp_ky4fXhY2BA")
    } else if(text.includes("نعره")) {
      sendVoice(chat_id, "AwACAgQAAxkBAAM1aIFimyfinE4QqCCdXc5R_cM6_JgAAnQRAAJ6CFlStWCjxFwoSls2BA")
    } else if(text.includes(" خواب")) {
      sendMessage(chat_id, "توش")
    } else if(text.includes("سیو")) {
      sendVideo(chat_id, "BAACAgQAAxkBAAM5aIFkZ3-yGzB1q4p8UXc8EBWNV9AAAssZAAKnDQABUqK1z6cQWWYbNgQ")
    } else if(text.includes(" کیر")) {
      sendVoice(chat_id, "AwACAgQAAxkBAANZaIKLTrqH-SI2qNLr_qH6_bn_80EAAhATAAIGjTBS68Kf-29gnGI2BA")
    } else if(text.includes(" کونی")) {
      sendVideoMessage(chat_id, "BAACAgQAAxkBAANXaIKKGGcn22wc_NkMhIvGNnvpYHUAAmwXAALnQeBQugaxOsqhHeA2BA")
    } else if(text.includes("دبه")) {
      sendReply(chat_id, 3692582, "ای روزگار")
    } else if(text.includes("دانش")) {
      sendMessage(chat_id, "طلب دانوش")
    } else if(text.includes("محاسبات")) {
      sendMessage(chat_id, "50-39=19")
    } else if(text.includes("هالند")) {
      sendPhoto(chat_id, "AgACAgQAAxkBAANbaIKNOstf-8JwFY-1Qk7b5Xoo-N8AAhe9MRtEPDlR47Z-s0rK-ZMBAAMCAAN5AAM2BA")
    } else if (text.trim().toLowerCase() === "vi") {
      var daysLeft = getViCountdown();
      if (daysLeft > 0) {
        sendMessage(chat_id, daysLeft - 1);
      } else if (daysLeft === 0) {
        sendMessage(chat_id, "🎉");
      }
    }
}
// for (let key in reactions) {
//   if (text.includes(key)) {
//     sendMessage(chat_id, reactions[key]);
//     return;
//   }
// }

  // Register
  var first_name = ""
  var last_name = ""
  var username = ""
  if(contents.message.from.first_name){
    first_name = contents.message.from.first_name
  }
  if(contents.message.from.last_name){
    last_name = contents.message.from.last_name
  }
  if(contents.message.from.username){
    username = contents.message.from.username
  }
  register(sender_id, first_name, last_name, username)
  }