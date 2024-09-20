const arr = [1, 6, 3, 7, 2, 8, 4, 9];
// 1. Tạo một mảng mới chứa các số lớn hơn 5 từ mảng ban đầu.
// const newArray = arr.filter(number => number > 5);
// console.log(newArray);

//2. Sử dụng arrow function và reduce để tính tổng các phần tử trong mảng.
// const numbers = [1, 3, 7, 6, 5];
//
// const sum = arr.reduce((temp, item) => temp + item);
//
// console.log(sum);

// 3. Kiểm tra 1 mảng có chứa số V hay không nếu có trả về V không thì trả về "không tìm thấy"
// const  arr=[1,3,5,7,9];
// const v=3;
// if (arr.includes(v)){
//     console.log(`Số ${v} có trong mảng`);
// }else {
//     console.log("không tìm thấy");
// }

//4. Kiểm tra 1 mảng tất cả các phần tử trong mảng đó có lớn hơn 0 hay không?.


// const allGreaterThanZero = arr.every(element => element > 0);
//
// if (allGreaterThanZero) {
//     console.log("Tất cả các phần tử trong mảng lớn hơn 0");
// } else {
//     console.log("Có phần tử trong mảng không lớn hơn 0");
// }

//5. Tìm phần tử đầu tiên trong mảng lớn hơn 3.

// const firstGreaterThanThree = arr.find(element => element > 3);
//
// if (firstGreaterThanThree !== undefined) {
//     console.log(`Phần tử đầu tiên lớn hơn 3 là: ${firstGreaterThanThree}`);
// } else {
//     console.log("Không tìm thấy phần tử nào lớn hơn 3");
// }

//6. Sử dụng destructuring với rest parameter để trích xuất phần tử đầu tiên vào biến "first" và các phần tử còn lại vào một mảng mới "rest".
// const [first,...rest]=arr;
// console.log(`phần tử đầu tiên: ${first}`);
// console.log(`phần tử còn lại: ${rest}`);

//7. Sử dụng destructuring để trích xuất các giá trị "name" và "age" từ một mảng chứa các đối tượng "person".


