/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time.track;

import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.time.TimeEntry;
import java.net.URL;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author ayalamanchili
 */
public class AvantelEmployeeTimeDataMapperTest {

    @InjectMocks
    private AvantelEmployeeTimeDataMapper avantelEmployeeTimeDataMapper;

    @Mock
    private OfficeServiceConfiguration officeServiceConfiguration;
    @Mock
    private BulkImport bulkImport;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
    public void testMapAvantelTimeRecords() {
        when(officeServiceConfiguration.getContentManagementLocationRoot()).thenReturn("");
        URL url = getClass().getResource("/avantel-employee-time-test-data.xls");
        when(bulkImport.getFileUrl()).thenReturn(url.getPath());
        List<TimeEntry> result = avantelEmployeeTimeDataMapper.mapAvantelTimeRecords(bulkImport);
    }

}
