const wrapper = document.querySelector(".wrapper");
const question = document.querySelector(".question");
const gif = document.querySelector(".gif");
const yesBtn = document.querySelector(".yes-btn");
const noBtn = document.querySelector(".no-btn");
const questionPrompt = document.querySelector(".question-prompt");

yesBtn.addEventListener("click", () => {
    question.innerHTML = "Anh đúng là đồ tòyyyyyyy 🥺<br>dỗiiii x10000000";
    gif.src = "https://media.giphy.com/media/vvc1dJPLEU2QOw9cXy/giphy.gif";

    // Ẩn cả hai nút Yes và No
    yesBtn.style.display = "none";
    noBtn.style.display = "none";
    questionPrompt.style.display = "none"; // Ẩn dòng chữ khi người dùng nhấn vào nút Yes
});

// noBtn.addEventListener("mouseover", () => {
//     const noBtnRect = noBtn.getBoundingClientRect();
//     const maxX = window.innerWidth - noBtnRect.width;
//     const maxY = window.innerHeight - noBtnRect.height;
//
//     const randomX = Math.floor(Math.random() * maxX);
//     const randomY = Math.floor(Math.random() * maxY);
//
//     noBtn.style.left = randomX + "px";
//     noBtn.style.top = randomY + "px";
// });

// Chuyển hướng trang khi người dùng nhấn vào nút "có iuu em😽"
noBtn.addEventListener("click", () => {
    window.location.href = "https://www.facebook.com/abc2cb08-7642-42be-a8a9-a1fa91174dd2"; // Thay đổi URL theo ý muốn
});
