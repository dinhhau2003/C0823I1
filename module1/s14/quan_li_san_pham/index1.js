let productList = [];

function displayProductList() {
    let productListHTML = "";
    for (let i = 0; i < productList.length; i++) {
        productListHTML += `
            <tr>
                <td>${productList}</td>
                <td>
                    <button class="btn" onclick="editProduct(${i})">ADD</button>
                    <button class="btn" onclick="deleteProduct(${i}) ">DeLete</button>
                </td>
            <tr/>
        
        `;
    }
    document.getElementById("productList").innerHTML = productListHTML;
}

function addProductList() {
    let addProduct = document.getElementById("productName").value;
    if (addProduct !== null) {
        productList.push(addProduct);
        displayProductList();
    }
}

function editProduct(index) {
    let newProductName = prompt("vui long nhap ten can sua ", productList[index]);
    if (newProductName !== null)
        newProductName = productList[index];
    displayProductList();
}

function deleteProduct(index) {
    let deleteProduct=confirm("xac nhan xoa: ");
    if(deleteProduct) {
        productList.splice(index, 1);
        displayProductList();
    }
}
displayProductList();