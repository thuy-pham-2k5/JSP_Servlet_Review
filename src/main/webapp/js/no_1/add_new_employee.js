const department = document.getElementById('departmentSelect');

department.addEventListener("click", function () {
    if (!this.disabled) { // Kiểm tra nếu phần tử không bị vô hiệu hóa
        const value = this.value;
        if (value === "" || value === null) {
            this.setCustomValidity("Please choose an option");
        } else {
            this.setCustomValidity("");
        }
    }
});
