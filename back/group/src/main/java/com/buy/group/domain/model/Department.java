package com.buy.group.domain.model;

public class Department {
    private static final String THE_CODE_IS_REQUIRED = "The code field is required";
    private static final String THE_NAME_IS_REQUIRED = "The name field is required";

    private Long id;
    private String code;
    private String name;

    public Department() {
    }

    public Department(Long id, String code, String name) {
        DataValidator.validateNull(code, THE_CODE_IS_REQUIRED);
        DataValidator.validateNull(name, THE_NAME_IS_REQUIRED);
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}