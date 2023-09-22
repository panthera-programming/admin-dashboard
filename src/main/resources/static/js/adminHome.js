
var createStaffForm = document.getElementById("create-staff-form")
var createProductForm = document.getElementById("create-product-form")
var createClientForm = document.getElementById("create-client-form")
/*function staffCreation(container)
{
    document.getElementById("create-staff-link").addEventListener("click", () => {
        container.classList.replace("d-none", "d-block")
    })
    document.getElementById("cancel-staff").addEventListener("click", () => {
        document.getElementById("create-staff-form").classList.replace("d-block", "d-none")
    })
}*/

function handleDropDowns()
{
    document.getElementById("toggleDrop1").addEventListener("click", () => {
        document.querySelector(".drop-down-prod").classList.toggle("d-none")
    })
    document.getElementById("toggleDrop2").addEventListener("click", () => {
        document.querySelector(".drop-down-client").classList.toggle("d-none")
    })
}
function generalOperations(linkBtn, container, cancelBtn)
{
    //msg ="Mail " + document.getElementById("client-mail").textContent
    document.getElementById(linkBtn).addEventListener("click", () => {
        document.getElementById(container).classList.replace("d-none", "d-block")
        //document.getElementById("bulk-mail-form").children[0].innerText = msg
    })
    document.getElementById(cancelBtn).addEventListener("click", () => {
        document.getElementById(container).classList.replace("d-block", "d-none")
    })
}

document.addEventListener("DOMContentLoaded", function() {
    //staffCreation(createStaffForm)
    /*productCreation(createProductForm)
    clientCreation(createClientForm)
    bulkEmail()
    bulkSms()*/
    handleDropDowns()
    generalOperations("bulk-sms-link","bulk-sms-form","cancel-sms")
    generalOperations("bulk-mail-link","bulk-mail-form","cancel-mail")
    generalOperations("create-product-link","create-product-form","cancel-product")
    generalOperations("create-client-link","create-client-form","cancel-client")
    generalOperations("client-mail","bulk-mail-form","cancel-mail")
    generalOperations("client-phone","bulk-sms-form","cancel-sms")
});

