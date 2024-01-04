
function showToast(message) {
    console.log("This is message from inside of show toast")
    var toastElement = document.getElementById('toast');
    if (toastElement) {
        toastElement.innerText = message;
        toastElement.style.display = 'block';

        // Hide the toast after a few seconds
        setTimeout(function () {
            toastElement.style.display = 'none';
        }, 3000); // Adjust the timeout as needed
    }
}