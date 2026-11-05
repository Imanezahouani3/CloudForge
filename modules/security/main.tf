resource "aws_security_group" "api" {
  name        = "${var.project_name}-${var.environment}-api-sg"
  description = "Allow API access only from an approved IP"
  vpc_id      = var.vpc_id

  ingress {
    description = "Allow API access from approved IP"
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = [var.allowed_api_cidr]
  }

  egress {
    description = "Allow outbound HTTPS only (SSM, AWS APIs, package updates)"
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name        = "${var.project_name}-${var.environment}-api-sg"
    Project     = var.project_name
    Environment = var.environment
  }
}