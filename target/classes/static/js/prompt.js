/**
 * 显示错误提示
 * @param {Object} inputField
 * @param {Object} message
 */
function showErrorMessage(inputField, message, isSelect) {
	let parentNode = inputField.parentNode.parentNode.parentNode
	let nextElement = inputField.parentNode.parentNode.nextElementSibling
	if (nextElement) {
		if (nextElement.name == 'errorField') {
			nextElement.remove()
		}
	}
	let errorField = document.createElement('div')
	if(isSelect) {
		inputField.parentNode.parentNode.parentNode.classList.add('input-error-border')
	} else {
		inputField.parentNode.parentNode.classList.add('input-error-border')
	}
	errorField.name = 'errorField'
	errorField.className = 'input-error'
	errorField.innerHTML = message
	parentNode.insertBefore(errorField,
		inputField.parentNode.parentNode.nextElementSibling)
}

/**
 * 关闭错误提示
 * @param {Object} inputField
 */
function offErrorMessage(inputField, isSelect) {
	if(isSelect) {
		inputField.parentNode.parentNode.parentNode.classList.remove('input-error-border')
	} else {
		inputField.parentNode.parentNode.classList.remove('input-error-border')
	}
	let nextElement = inputField.parentNode.parentNode.nextElementSibling
	if (nextElement) {
		if (nextElement.name == 'errorField') {
			nextElement.remove()
		}
	}
}
