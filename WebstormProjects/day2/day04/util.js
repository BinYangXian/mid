
/**
 *
 * @param parentNode   ���ڵ����
 * @returns {Array}   ���е�Ԫ���ӽڵ�
 */
function getChildNodes(parentNode){
    //������õ�  �ı��ڵ�
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
 * @param parentNode  ���ڵ����
 * @returns {*}  ��һ���ӽڵ�
 */
function getFirstChild(parentNode){
    var firstChild=parentNode.firstChild;
    //������������     �ı��ڵ��򷵻�����һ���ֵܽڵ�
    if(firstChild.nodeType==3){
        return firstChild.nextSibling;
    }
    return firstChild;
}

/**
 *
 * @param parentNode  ���ڵ����
 * @returns {*}   ���һ���ӽڵ�
 */
function getLastChild(parentNode){
    var lastChild=parentNode.lastChild;
    //����ߵ�����
    if(lastChild.nodeType==3){
        return lastChild.previousSibling;
    }
    //ie�ߵ�����
    return lastChild;
}
/**
 *
 * @param objNode   Ԫ�ؽڵ�
 * @returns {*}  ��һ���ֵܽڵ�
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
 * @param objNode   Ԫ�ؽڵ�
 * @returns {*} ��һ���ֵܽڵ�
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
 * @param idOrName  ����������id  idǰ����Ҫ����#   nameֱ�Ӵ�
 * @returns {*}   ���ض�ӦҪ�ҵ�Ԫ�ض��������
 */
function $(idOrName){
    if(idOrName.substr(0,1)=="#"){
        return document.getElementById(idOrName.substring(1));
    }else{
        return document.getElementsByName(idOrName);
    }
}