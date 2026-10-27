
variable "aws_region" {
  description = "AWS region where CloudForge deploys resources"
  type        = string
  default     = "us-east-2"
}

variable "project_name" {
  description = "Name of the CloudForge project"
  type        = string
  default     = "cloudforge"
}

variable "environment" {
  description = "Deployment environment"
  type        = string
  default     = "dev"
}

variable "vpc_cidr" {
  description = "CIDR block for the CloudForge VPC"
  type        = string
  default     = "10.0.0.0/16"
}

variable "public_subnet_cidr" {
  description = "CIDR block for the public subnet"
  type        = string
  default     = "10.0.1.0/24"
}

variable "allowed_api_cidr" {
  description = "CIDR range allowed to access the API"
  type        = string

  validation {
    condition     = can(cidrnetmask(var.allowed_api_cidr))
    error_message = "allowed_api_cidr must be a valid CIDR block."
  }
}
