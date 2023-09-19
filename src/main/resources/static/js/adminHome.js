
var createStaffForm = document.getElementById("create-staff-form")
var createProductForm = document.getElementById("create-product-form")
var createClientForm = document.getElementById("create-client-form")
function staffCreation(container)
{
    document.getElementById("create-staff-link").addEventListener("click", () => {
        container.classList.replace("d-none", "d-block")
    })
    document.getElementById("cancel-staff").addEventListener("click", () => {
        document.getElementById("create-staff-form").classList.replace("d-block", "d-none")
    })
}

function productCreation(container)
{
    document.getElementById("create-product-link").addEventListener("click", () => {
        container.classList.replace("d-none", "d-block")
    })
    document.getElementById("cancel-product").addEventListener("click", () => {
        document.getElementById("create-product-form").classList.replace("d-block", "d-none")
    })
}
function clientCreation(container)
{
    document.getElementById("create-client-link").addEventListener("click", () => {
        container.classList.replace("d-none", "d-block")
    })
    document.getElementById("cancel-client").addEventListener("click", () => {
        document.getElementById("create-client-form").classList.replace("d-block", "d-none")
    })
}
function bulkSms()
{
    document.getElementById("bulk-sms-link").addEventListener("click", () => {
        document.getElementById("bulk-sms-form").classList.replace("d-none", "d-block")
    })
    document.getElementById("cancel-sms").addEventListener("click", () => {
        document.getElementById("bulk-sms-form").classList.replace("d-block", "d-none")
    })
}
function bulkEmail()
{
    document.getElementById("bulk-mail-link").addEventListener("click", () => {
        document.getElementById("bulk-mail-form").classList.replace("d-none", "d-block")
    })
    document.getElementById("cancel-mail").addEventListener("click", () => {
        document.getElementById("bulk-mail-form").classList.replace("d-block", "d-none")
    })
}

document.addEventListener("DOMContentLoaded", function() {
    // Your code here
    staffCreation(createStaffForm)
    productCreation(createProductForm)
    clientCreation(createClientForm)
    bulkEmail();
    bulkSms();
});

