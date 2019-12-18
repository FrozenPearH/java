package com.hand.hlz25720.hap.dto;

/**Auto Generated By Hap Code Generator**/
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Table;
import com.hand.hap.system.dto.BaseDTO;
import org.hibernate.validator.constraints.NotEmpty;
@ExtensionAttribute(disable=true)
@Table(name = "hap_org_companys")
public class OrgCompanys extends BaseDTO {

     public static final String FIELD_COMPANY_ID = "companyId";
     public static final String FIELD_COMPANY_NUMBER = "companyNumber";
     public static final String FIELD_COMPANY_NAME = "companyName";
     public static final String FIELD_ENABLED_FLAG = "enabledFlag";


     @Id
     @GeneratedValue
     private Long companyId; //公司ID

     @NotEmpty
     @Length(max = 60)
     private String companyNumber; //公司编号

     @NotEmpty
     @Length(max = 240)
     private String companyName; //公司名称

     @NotEmpty
     @Length(max = 1)
     private String enabledFlag; //启用标识


     public void setCompanyId(Long companyId){
         this.companyId = companyId;
     }

     public Long getCompanyId(){
         return companyId;
     }

     public void setCompanyNumber(String companyNumber){
         this.companyNumber = companyNumber;
     }

     public String getCompanyNumber(){
         return companyNumber;
     }

     public void setCompanyName(String companyName){
         this.companyName = companyName;
     }

     public String getCompanyName(){
         return companyName;
     }

     public void setEnabledFlag(String enabledFlag){
         this.enabledFlag = enabledFlag;
     }

     public String getEnabledFlag(){
         return enabledFlag;
     }

     }
