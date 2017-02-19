function multiply() {
    for (var i = 1; i < 10; i++) {
        for (var j = 1; j <= i; j++) {
            document.write(j + "*" + i + "=" + i * j + "\t\t");
        }
        document.write("<br/>");
    }
}
function bubblingSort() {
    var bs = [43, 31, 321, 43245, 7657, 561, 321, 23];
    document.write("there is a array:" + bs + "<br/>");
    for (var j = 0; j < bs.length; j++) {

        for (var i = 0; i < bs.length - j - 1; i++) {
            if (bs[i + 1] > bs[i]) {
                var after = bs[i + 1];
                bs[i + 1] = bs[i];
                bs[i] = after;
            }
        }
    }
    document.write("array has been sorted:" + bs);
}
function yangHuiTriangle() {
    if (arguments.length == 1) {
        if (arguments[0]>0) {
                document.write("1");
        }
        if(arguments[0]>1){
            document.write("<br/>"+"1" + " 1");
        }
        if(arguments[0]>2){

            var numY=new Array(arguments[0]); //一维数组
            var numX=new Array(numY.length);//二维
            var temp=new Array(arguments[0]);
            temp[0]=1;
            temp[1]=1;
            numX[0]=1;

            for(var i=3;i<=numX.length;i++){
                for(var j=1;j<=numY.length;j++){
                    if(j==1|j==numY.length){
                        //numY[j]=1;
                        document.write(" 1");
                    }else{
                        var temp=new Array(i-1)
                        temp=numX[i-1];   //numY[3,2]=num[2,1]+num[2,2];
                        //numY[j]=numY[i-1]+numY[i];
                        //temp[j-1]+temp[j];
                        document.write(" "+temp[j-1]+temp[j]);
                    }
                }
                document.write("</br>");
            }
        }
    }
}