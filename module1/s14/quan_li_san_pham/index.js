var productList = [];

function displayProductList() {
    let productListHTML = "";
    for (var i = 0; i < productList.length; i++) {
        productListHTML += `
                    <tr>
                        <td>${productList[i]}</td>
                        <td>
                            <button class="btn" onclick="editProduct(`+i+`)">Sửa</button>
                            <button class="btn" onclick="deleteProduct(${i})">Xoá</button>
                        </td>
                    </tr>
                `;
    }
    document.getElementById("productList").innerHTML = productListHTML;
}

function addProduct() {
    var productName = document.getElementById("productName").value;
    if (productName!==null) {
        productList.push(productName);
        // document.getElementById("productName").value = "";
        displayProductList();
    }
}

function editProduct(index) {
    var newProductName = prompt("Nhập tên mới cho sản phẩm:", productList[index]);
    if (newProductName !== null) {
        productList[index] = newProductName;
        displayProductList();
    }
}

function deleteProduct(index) {
    var confirmation = confirm("Bạn có muốn xoá sản phẩm này?");
    if (confirmation) {
        productList.splice(index, 1);
        displayProductList();
    }
}

displayProductList();