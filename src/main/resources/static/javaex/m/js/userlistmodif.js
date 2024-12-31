// 添加拖动和调整大小的功能
document.addEventListener('DOMContentLoaded', function() {
    const modal = document.getElementById('editModal');
    const modalContent = modal.querySelector('.modal-content');
    const modalHeader = modal.querySelector('.modal-header');

    let isDragging = false;
    let currentX;
    let currentY;
    let initialX;
    let initialY;

    // 拖动功能
    modalHeader.addEventListener('mousedown', dragStart);
    document.addEventListener('mousemove', drag);
    document.addEventListener('mouseup', dragEnd);

    function dragStart(e) {
        initialX = e.clientX - modalContent.offsetLeft;
        initialY = e.clientY - modalContent.offsetTop;

        if (e.target === modalHeader) {
            isDragging = true;
        }
    }

    function drag(e) {
        if (isDragging) {
            e.preventDefault();
            currentX = e.clientX - initialX;
            currentY = e.clientY - initialY;

            // 设置边界限制
            const maxX = window.innerWidth - modalContent.offsetWidth;
            const maxY = window.innerHeight - modalContent.offsetHeight;

            currentX = Math.min(Math.max(0, currentX), maxX);
            currentY = Math.min(Math.max(0, currentY), maxY);

            modalContent.style.left = currentX + 'px';
            modalContent.style.top = currentY + 'px';
            modalContent.style.transform = 'none';
        }
    }

    function dragEnd() {
        isDragging = false;
    }
});
// 打开模态框时
modal.style.display = 'block';
modal.classList.add('show');

// 关闭模态框时
modal.classList.remove('show');
setTimeout(() => {
    modal.style.display = 'none';
}, 300);