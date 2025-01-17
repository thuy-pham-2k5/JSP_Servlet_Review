const targetButton = document.getElementById('search');
const buttonHeight = window.getComputedStyle(targetButton).height;
const inputField = document.querySelector('input[type="text"]');
inputField.style.height = buttonHeight;