/*
 * Copyright 2018-present, Nike, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the Apache-2.0 license found in
 * the LICENSE file in the root directory of this source tree.
 *
 */
package com.nike.epc.model.gsrnp;

import static com.nike.epc.util.Validation.notNullOrEmpty;

/*
 * From the standard:
 *  The Global Service Relation Number - Provider (GSRNP) EPC scheme is used to assign a unique identity to a service
 *   provider.
 *
 *  In the epc uris, the companyPrefix and serviceReference will both be zero padded such that when they are
 *   concatenated, the resultant string is 17 digits.
 *
 *  The serviceReference should be assigned by the managing entity to a particular service provider.
 */
public class Gsrnp {
  private final String companyPrefix, serviceReference;

  private Gsrnp(String companyPrefix, String serviceReference) {
    this.companyPrefix = companyPrefix;
    this.serviceReference = serviceReference;
  }

  public String companyPrefix() {
    return companyPrefix;
  }

  public String serviceReference() {
    return serviceReference;
  }

  public static final class Builder {
    private String companyPrefix, serviceReference;

    private Builder() {}

    public Builder withCompanyPrefix(String companyPrefix) {
      this.companyPrefix = companyPrefix;
      return this;
    }

    public Builder withServiceReference(String serviceReference) {
      this.serviceReference = serviceReference;
      return this;
    }

    public Gsrnp build() {
      return new Gsrnp(notNullOrEmpty(companyPrefix), notNullOrEmpty(serviceReference));
    }
  }

  public static Builder builder() {
    return new Builder();
  }
}
