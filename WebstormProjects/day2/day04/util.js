
/**
 *
 * @param parentNode   父节点对象
 * @returns {Array}   所有的元素子节点
 */
function getChildNodes(parentNode){
    //火狐会拿到  文本节点
    var childNodes=parentNode.childNodes;
    var children=[];
    for(var i=0;i<childNodes.length;i++){
        if(childNodes[i].nodeType==1){
            children.push(childNodes[i]);
        }
    }
    return children;
}

/**
 *
 * @param parentNode  父节点对象
 * @returns {*}  第一个子节点
 */
function getFirstChild(parentNode){
    var firstChild=parentNode.firstChild;
    //如果火狐进来是     文本节点则返回其下一定兄弟节点
    if(firstChild.nodeType==3){
        return firstChild.nextSibling;
    }
    return firstChild;
}

/**
 *
 * @param parentNode  父节点对象
 * @returns {*}   最后一个子节点
 */
function getLastChild(parentNode){
    var lastChild=parentNode.lastChild;
    //火狐走的流程
    if(lastChild.nodeType==3){
        return lastChild.previousSibling;
    }
    //ie走的流程
    return lastChild;
}
/**
 *
 * @param objNode   元素节点
 * @returns {*}  下一个兄弟节点
 */
function getNextSibling(objNode){
    var nextNode=objNode.nextSibling;
    if(nextNode.nodeType==3){
        return nextNode.nextSibling;
    }
    return nextNode;
}

/**
 *
 * @param objNode   元素节点
 * @returns {*} 上一个兄弟节点
 */
function getPreviousSibling(objNode){
    var previous=objNode.previousSibling;
    if(previous.nodeType==3){
        return previous.previousSibling;
    }
    return previous;
}

/**
 *
 * @param idOrName  如果传入的是id  id前面需要加上#   name直接传
 * @returns {*}   返回对应要找的元素对象或数组
 */
function $(idOrName){
    if(idOrName.substr(0,1)=="#"){
        return document.getElementById(idOrName.substring(1));
    }else{
        return document.getElementsByName(idOrName);
    }
}