/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.snapshotbasedrecoveries.recovery;

import org.elasticsearch.common.settings.Settings;

import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.not;

public class GCSSnapshotBasedRecoveryIT extends AbstractSnapshotBasedRecoveryRestTestCase {

    @Override
    protected String repositoryType() {
        return "gcs";
    }

    @Override
    protected Settings repositorySettings() {
        final String bucket = System.getProperty("test.gcs.bucket");
        assertThat(bucket, not(blankOrNullString()));

        final String basePath = System.getProperty("test.gcs.base_path");
        assertThat(basePath, not(blankOrNullString()));

        return Settings.builder().put("client", "snapshot_based_recoveries").put("bucket", bucket).put("base_path", basePath).build();
    }
}
