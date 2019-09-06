package com.paro.sngiz.Validator;

import com.paro.sngiz.EmployerWrapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PhotoValidator implements Validator {

    public static final String JPEG_MIME_TYPE="image/jpeg";
    public static final String JPG_MIME_TYPE="image/jpg";
    public static final String PNG_MIME_TYPE="image/png";
    public static final long TEN_MB_IN_BYTES = 10485760;
    //1-EmployerWrapper
    @Override
    public boolean supports(Class<?> clazz) {

        return EmployerWrapper.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployerWrapper createdEmployer=(EmployerWrapper) target;

        MultipartFile employerPhoto=createdEmployer.getImage();
        System.out.println("Is employer photo empty? "+employerPhoto.isEmpty()+"\n"+
                "Type of employer photo "+employerPhoto.getContentType()+"\n"+
                "Size of employer photo "+employerPhoto.getSize()+"\n"+
                "JPEG_MIME_TYPE.equalsIgnoreCase(employerPhoto.getContentType()) "+JPEG_MIME_TYPE.equalsIgnoreCase(employerPhoto.getContentType()));

        if(employerPhoto.isEmpty()){
            errors.rejectValue("image", "upload.file.required");
        }
        else if((!JPEG_MIME_TYPE.equalsIgnoreCase(employerPhoto.getContentType()))&&(!PNG_MIME_TYPE.equalsIgnoreCase(employerPhoto.getContentType()))){
            errors.rejectValue("image", "upload.invalid.file.type");
        }

        else if(employerPhoto.getSize() > TEN_MB_IN_BYTES){
            errors.rejectValue("image", "upload.exceeded.file.size");
        }


    }
}
