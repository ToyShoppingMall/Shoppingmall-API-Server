function initFrontLayer() {
    const layer = document.getElementById('front-layer');

    layer.appendChild(createFrontLayerDiv('header'));
    layer.appendChild(createFrontLayerDiv('footer'));
}

function createFrontLayerDiv(value) {
    let div = document.createElement('div');

    div.setAttribute('id', value);
    div.setAttribute('class', value);

    return div;
}