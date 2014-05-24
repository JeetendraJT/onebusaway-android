package com.joulespersecond.oba.request.test;

import com.joulespersecond.oba.elements.ObaRegion;
import com.joulespersecond.oba.request.ObaRegionsRequest;
import com.joulespersecond.oba.request.ObaRegionsResponse;

/**
 * Tests Regions API requests and responses
 */
public class RegionsTest extends ObaTestCase {

    public void testRequest() {
        ObaRegionsRequest request =
                ObaRegionsRequest.newRequest(getContext());
        ObaRegionsResponse response = request.call();
        assertOK(response);
        final ObaRegion[] list = response.getRegions();
        assertTrue(list.length > 0);
        for (ObaRegion region : list) {
            assertNotNull(region.getName());
        }
    }

    public void testBuilder() {
        ObaRegionsRequest.Builder builder =
                new ObaRegionsRequest.Builder(getContext());
        ObaRegionsRequest request = builder.build();
        assertNotNull(request);
    }
}
