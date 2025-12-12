#!/bin/bash

# Build and push Quarkus application to Quay.io
# Usage: ./build-and-push.sh [TAG] [QUAY_USER]
#
# Examples:
#   ./build-and-push.sh                    # Uses default tag 'latest' and user 'dseveria'
#   ./build-and-push.sh v1.0.0             # Uses tag 'v1.0.0'
#   ./build-and-push.sh v1.0.0 myuser      # Uses tag 'v1.0.0' and user 'myuser'

set -e

# Configuration
TAG="${1:-latest}"
QUAY_USER="${2:-dseveria}"
APP_NAME="discounts-config-mandatory"
IMAGE="quay.io/${QUAY_USER}/${APP_NAME}:${TAG}"
DOCKERFILE="src/main/docker/Dockerfile.jvm"

echo "============================================"
echo "Building Quarkus Application"
echo "============================================"
echo "App Name:  ${APP_NAME}"
echo "Image:     ${IMAGE}"
echo "Dockerfile: ${DOCKERFILE}"
echo "============================================"

# Step 1: Login to Quay (if not already logged in)
echo ""
echo "[1/4] Checking Quay.io login..."
if ! podman login --get-login quay.io &>/dev/null; then
    echo "Please login to Quay.io:"
    podman login quay.io -u "${QUAY_USER}"
fi

# Step 2: Build the application with Maven
echo ""
echo "[2/4] Building application with Maven..."
./mvnw clean package -DskipTests

# Step 3: Build the container image
echo ""
echo "[3/4] Building container image..."
podman build -f ${DOCKERFILE} -t ${IMAGE} .

# Step 4: Push to Quay.io
echo ""
echo "[4/4] Pushing image to Quay.io..."
podman push ${IMAGE}

echo ""
echo "============================================"
echo "SUCCESS! Image pushed to: ${IMAGE}"
echo "============================================"
echo ""
echo "To deploy without config (will FAIL - demonstrates mandatory config):"
echo "  kubectl run test-mandatory --image=${IMAGE}"
echo ""
echo "To deploy WITH config (will work):"
echo "  kubectl run test-mandatory --image=${IMAGE} \\"
echo "    --env='application.version=1.0.0' \\"
echo "    --env='application.colour=blue' \\"
echo "    --env='application.mode=production'"
echo ""

