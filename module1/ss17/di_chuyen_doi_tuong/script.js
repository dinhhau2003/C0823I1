function Hero(image, top, left, size) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;

    this.getHeroElement = function() {
        return '<img width="' + this.size + '"' +
            ' height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    }

    this.moveUp = function() {
        if (this.top > 0) {
            this.top -= 100; // Điều chỉnh khoảng cách di chuyển lên
        }
    }

    this.moveDown = function() {
        if (this.top < window.innerHeight - this.size) {
            this.top += 10; // Điều chỉnh khoảng cách di chuyển xuống
        }
    }

    this.moveLeft = function() {
        if (this.left > 0) {
            this.left -= 10; // Điều chỉnh khoảng cách di chuyển sang trái
        }
    }

    this.moveRight = function() {
        if (this.left < window.innerWidth - this.size) {
            this.left += 10; // Điều chỉnh khoảng cách di chuyển sang phải
        }
    }
}

var hero = new Hero('anh-anh-da-den-cuoi_035824967.jpg', 20, 30, 200);

function start() {
    document.getElementById('game').innerHTML = hero.getHeroElement();
}

// Xử lý sự kiện khi phím bấm được nhấn
document.addEventListener('keydown', function(event) {
    if (event.key === 'ArrowUp') {
        hero.moveUp();
    } else if (event.key === 'ArrowDown') {
        hero.moveDown();
    } else if (event.key === 'ArrowLeft') {
        hero.moveLeft();
    } else if (event.key === 'ArrowRight') {
        hero.moveRight();
    }
    start(); // Cập nhật vị trí của nhân vật sau mỗi lần di chuyển
});

start();





