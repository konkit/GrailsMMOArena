package pl.tenerowicz.mmoarena

import org.hibernate.cfg.ImprovedNamingStrategy

/**
 * Created by konkit on 03.03.15.
 */
class NamingStrategy  extends ImprovedNamingStrategy {

    String classToTableName(String className) {
        "mmoarena_table_" + super.classToTableName(className)
    }

    String propertyToColumnName(String propertyName) {
        "mmoarena_column_" + super.propertyToColumnName(propertyName)
    }
}
