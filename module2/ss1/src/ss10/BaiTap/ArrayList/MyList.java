package ss10.BaiTap.ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int  DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }
    public void add(int index, E element){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Error index: Index = "+index+", size = "+size);
        } else {
            if(size == elements.length){
                ensureCapacity(elements.length+1);
            }else {
                for (int i = size; i>index;i--){
                    elements[i] = elements[i-1];
                    size++;
                }
                elements[index] = element;
            }
        }
    }
    public void remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Error at index = " + index);
        } else {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i+1];
            }
            size--;
        }
    }
    public int size(){
        return this.size;
    }
    //tạo một bản sao của đối tượng MyList
    public MyList<E> clone(){
        MyList newArray = new MyList();
        newArray.elements = Arrays.copyOf(this.elements, this.size);
        newArray.size = this.size;
        return newArray;
    }
    //kiểm tra xem đối tượng MyList có chứa một phần tử cụ thể hay không
    public boolean contains(E o){
        for (int i = 0;i<size;i++){
            if(elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    //trả về chỉ số của phần tử đầu tiên trong danh sách có giá trị bằng với đối tượng được cung cấp
    public int indexOf(E o){
        int index = -1;
        for (int i =0;i<size;i++){
            if(elements[i].equals(0)){
                index=i;
                break;
            }
        }
        return index;
    }
    //Thêm phần tử vào cuối danh sách
    public boolean add(E o) {
        if (size == elements.length) {
            ensureCapacity(elements.length + 1);
        }
        elements[size++] = o;
        return true;
    }
    // lấy phần tử tại một vị trí cụ thể trong danh sách MyList
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    // xóa tất cả các phần tử trong danh sách MyList
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }
//mở rộng kích thước
    public void ensureCapacity(int minCapacity) {
        int newSize = this.elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }
}
