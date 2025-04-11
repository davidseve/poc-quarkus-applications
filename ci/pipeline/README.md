# Pipelines

podman login -u dseveria quay.io/dseveria
cp /run/user/1000/containers/auth.json /tmp/config.json
kubectl create secret generic docker-config --from-file=/tmp/config.json -n poc-pipelines

cd ci
oc apply -f pipeline.yaml -n poc-pipelines

oc create -f pv-discounts.yaml -n poc-pipelines
oc create -f pv-products.yaml -n poc-pipelines
oc create -f pipelinerun-discounts.yaml -n poc-pipelines
oc create -f pipelinerun-products.yaml -n poc-pipelines


Change image to public in Quay

