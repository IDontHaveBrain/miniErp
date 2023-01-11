import React, { Component } from "react";

const FormInput = (props) => {
  const {
    formData,
    labelName,
    onChange,
    onBlur,
    disable = false,
    required = false,
    showErrorMessage = true,
  } = props;

  return (
    <>
      <input
        id={formData.inputName}
        type='text'
        className={formData.isVaild ? "login-form" : "login-form invalid"}
        name={formData.inputName}
        value={formData.value}
        onChange={onChange}
        onBlur={onBlur}
        disabled={disable}
      />
      <label class Name='f_label'>
        {labelName ? labelName : ""}
        {formData.isRequired || required ? (
          <span className='required'>*</span>
        ) : null}
      </label>

      {/* 유효성체크 실패시 에러메세지 */}
      <span
        style={{ display: formData.isVaild ? "none" : "" }}
        className='invalid_txt'
      >
        {showErrorMessage ? formData.errorMessage : ""}
      </span>
    </>
  );
};

export default FormInput;
