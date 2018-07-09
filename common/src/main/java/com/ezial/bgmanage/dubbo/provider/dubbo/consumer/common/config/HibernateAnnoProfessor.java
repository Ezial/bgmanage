package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.config;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by Ezial on 2018/1/29.
 */
public class HibernateAnnoProfessor extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {


        return false;
    }
}
