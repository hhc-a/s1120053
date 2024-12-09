package tw.edu.pu.csim.s1120053

class maria (val screenW:Int, val screenH:Int, scale:Float){
    var w = (200 * scale).toInt()  //病毒寬度
    var h = (200 * scale).toInt()  //病毒高度
    var x = screenW  //病毒x軸座標
    var y = (screenH/2).toInt()  //病毒y軸座標

    var pictNo = 0  //切換圖片

    fun Reset(){
        x = screenW
        y = (screenH/2).toInt()

    }
    fun Fly() {
        pictNo++
        if (pictNo > 1) {
            pictNo = 0
        }

        x += 50
//        y += (-20 .. 20).random()
        if((x+w) < 0){
            Reset()
        }
    }

}
