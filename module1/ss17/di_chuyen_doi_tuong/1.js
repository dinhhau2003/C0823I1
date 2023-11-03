/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size){
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;

    this.getHeroElement = function(){
        return '<img width="'+ this.size + '"' +
            ' height="'+ this.size + '"' +
            ' src="' + this.image +'"' +
            ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
    }

    this.moveRight = function(){
        this.left += 200;
        console.log('ok: ' + this.left);
    }
    this.moveDown = function() {

            this.top += 100; // Điều chỉnh khoảng cách di chuyển xuống
        console.log('ok: ' + this.left);
    }
    this.moveLeft = function(){
        this.left -= 100;
        console.log('ok: ' + this.left);
    }
    this.moveUp = function() {

        this.top -= 100; // Điều chỉnh khoảng cách di chuyển lên
        console.log('ok: ' + this.left);
    }
}

var hero = new Hero('anh-anh-da-den-cuoi_035824967.jpg', 20, 30, 200);

function start(){
    if(hero.left < window.innerWidth - hero.size){
        hero.moveRight();
    } else
    if (hero.top < window.innerHeight - hero.size) {
        hero.moveDown();
    }else
        if (hero.left > window.innerWidth - hero.size){
            hero.moveLeft();
    }else
        if (hero.top > window.innerHeight - hero.size){
            hero.moveUp();
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}

start();