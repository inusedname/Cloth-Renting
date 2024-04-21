function goBack() {
    console.log('Go back')
    const currentUrl = window.location.href;
    const basePath = currentUrl.split('?')[0]; // Extract base path without query parameters
    window.location.href = basePath.split('/').slice(0, -1).join('/');
}

document.getElementsByClassName('btn-back')[0].addEventListener('click', goBack);