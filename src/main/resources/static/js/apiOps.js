
function formToJson(formContainer, urlLink, respIndicator, failIndicator)
{
    document.getElementById(formContainer).addEventListener("submit", (form) => {
        form.preventDefault()
        const formData = new FormData(form.target)
        const jsonData = {}
        formData.forEach((value, key) => {
            jsonData[key] = value
        })
        statusCode = postData(urlLink, jsonData)
        if (statusCode === 201)
        {
            document.getElementById(respIndicator).classList.replace("d-none", "d-flex")
        }
        document.getElementById(failIndicator).classList.replace("d-none", "d-flex")
    })
}

async function postData(url, data)
{
    var statusCode;
    fetch(url, 
        {
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(data)
        }
    ).then(response => {
        return (response.json())
    }).then(data => {
        statusCode = data.statusCode
    })

    return (statusCode)
}

document.addEventListener("DOMContentLoaded", () => {
    formToJson("create-product-form", "http://localhost:8080/api/product/new", "prod-response-success", "prod-response-failure")
    formToJson("create-client-form", "http://localhost:8080/api/client/new", "client-response-success", "client-response-failure")
    formToJson("create-staff-form", "http://localhost:8080/api/staff/new", "staff-response-success", "staff-response-failure")
})
