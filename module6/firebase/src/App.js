import React from 'react';
import AddProduct from './Component/AddProduct'; // Import component thêm sản phẩm
import ProductList from './Component/ProductList'; // Import component danh sách sản phẩm

function App() {
  return (
      <div className="App">
        <h1>Quản lý sản phẩm</h1>

        {/* Phần thêm sản phẩm */}
        <AddProduct />

        <hr />

        {/* Phần hiển thị danh sách sản phẩm */}
        <ProductList />
      </div>
  );
}

export default App;
