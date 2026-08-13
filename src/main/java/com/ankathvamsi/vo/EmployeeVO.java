package com.ankathvamsi.vo;

//package com.ankathvamsi.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer empId;
    @NonNull
    private String ename;
    @NonNull
    private String job;
    @NonNull
    private Float sal;
    private Integer deptno;
}