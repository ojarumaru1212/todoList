/**
* 必須チェックを実施する。
* @param value チェック対象の値
* @return true:チェックOK、false:チェックNG
*/
const isRequired = (value) => {
	return value !== undefined && value !== null && value !== ""; 
}

/**
* 桁数チェックを実施する。
* @param value チェック対象の値
* @param minlength 最小桁数
* @param maxlength 最大桁数
* @return true:チェックOK、false:チェックNG
*/
const isLength = (value, minLength, maxLength) => {
	const valueLength = value.length;
	return valueLength >= minLength && valueLength <= maxLength;
}

/**
* 全角英数記号かどうかのチェックを実施する。（参考：https://javascript.programmer-reference.com/js-regexp-sample/）
* @param value チェック対象の値
* @return true:チェックOK、false:チェックNG
*/
const isFormat = (value) => {
	const FullWidth = new RegExp(/^([a-zA-Z0-9!-/:-@¥[-`{-~]|[^\x20-\x7e])*$/);
	/*const HalfWidth = new RegExp(/^[a-zA-Z0-9!-/:-@¥[-`{-~]*$/);*/
	/*return FullWidth.test(value) || HalfWidth.test(value);*/
	return FullWidth.test(value);
}