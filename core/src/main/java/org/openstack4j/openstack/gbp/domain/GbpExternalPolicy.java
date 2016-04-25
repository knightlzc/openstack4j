package org.openstack4j.openstack.gbp.domain;

import java.util.List;

import org.openstack4j.model.gbp.ExternalPolicy;
import org.openstack4j.model.gbp.PolicyRuleSet;
import org.openstack4j.model.gbp.builder.ExternalPolicyBuilder;
import org.openstack4j.openstack.common.ListResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;

@JsonRootName("external_policy")
public class GbpExternalPolicy implements ExternalPolicy{
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    @JsonProperty("tenant_id")
    private String tenantId;
    private String id;
    @JsonProperty("consumed_policy_rule_sets")
    private List<PolicyRuleSet> consumedPolicyRuleSets;
    @JsonProperty("provided_policy_rule_sets")
    private List<PolicyRuleSet> providedPolicyRuleSets;
    @JsonProperty("external_segments")
    private List<String> externalSegments;
    private boolean shared;
    
    @Override 
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(String tenantId) {
        this.tenantId=tenantId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }
    
    @Override
    public List<PolicyRuleSet> getConsumedPolicyRuleSets() {
        return consumedPolicyRuleSets;
    }


    @Override
    public List<PolicyRuleSet> getProvidedPolicyRuleSets() {
        return providedPolicyRuleSets;
    }


    @Override
    public List<String> getExternalSegments() {
        return externalSegments;
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isShared() {
        return shared;
    }


    @Override
    public ExternalPolicyBuilder toBuilder() {
        return new ExternalPolicyConcreteBuilder(this);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues().add("name", name).add("tenantId", tenantId).add("externalSegments", externalSegments).add("id", id).add("description", description).add("shared", shared).add("consumedPolicyRuleSets", consumedPolicyRuleSets).add("providedPolicyRuleSets", providedPolicyRuleSets).toString();
    }
    
    public static class ExternalPolicies extends ListResult<GbpExternalPolicy> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("external_policies")
        private List<GbpExternalPolicy> externalPolicys;

        @Override
        protected List<GbpExternalPolicy> value() {
            return externalPolicys;
        }
    }
    

                     
    
    public static class ExternalPolicyConcreteBuilder implements ExternalPolicyBuilder{

        private GbpExternalPolicy extPolicy;
        
        public ExternalPolicyConcreteBuilder(){
            this(new GbpExternalPolicy());
        }
        
        public ExternalPolicyConcreteBuilder(GbpExternalPolicy gbpExternalPolicy) {
            this.extPolicy=gbpExternalPolicy;
        }

        @Override
        public ExternalPolicy build() {
            return extPolicy;
        }

        @Override
        public ExternalPolicyBuilder from(ExternalPolicy in) {
            extPolicy = (GbpExternalPolicy)in;
            return this;
        }

        @Override
        public ExternalPolicyBuilder name(String name) {
            extPolicy.name=name;
            return this;
        }
        
    }

    public static ExternalPolicyBuilder builder() {
        return new ExternalPolicyConcreteBuilder();
    }

}
