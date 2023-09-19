
const passwordField = Document.getElementById("set-password")
const passwordConfirm = Document.getElementById("confirm-password")

function validatePassword(setField, confirmField)
{
    const pageUrl = window.location.href;
    let paramString = pageUrl.split('?')[1]
    let queryString = new URLSearchParams(paramString)
    const userId = queryString.entries()[0][1]
    if (setField.value == confirmField.value)
    {
        const data = {
            password: setField.value
        }
        postData(`http://localhost:8080/setPassword/?id=${userId}`, data)
        .then((data) => {
            console.log(data)
        })
        .catch((error) => {
            console.error(error)
        })
    }
}

async function postData(url, data)
{
    const response = await fetch(url, 
        {
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(data)
        }
    )
    return (response.json())
}
